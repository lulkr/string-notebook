package kr.lul.stringnotebook.viewmodel.organism

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.event.AddNodeEvent
import kr.lul.stringnotebook.domain.event.DeactivateEvent
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.event.ShowNotebookContextMenuEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookMenuContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectActivatedContext
import kr.lul.stringnotebook.state.organism.ObjectEditContext
import kr.lul.stringnotebook.viewmodel.atom.BaseViewModelet
import kr.lul.stringnotebook.viewmodel.atom.ViewModeletOwner
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class MainPaneViewModelet(
    page: ViewModeletOwner,
    initState: NotebookState
) : BaseViewModelet(page, "MainPaneViewModelet"), EventProcessor {
    internal val _notebook = MutableStateFlow(initState)
    val notebook: StateFlow<NotebookState> = _notebook

    internal val _context = MutableStateFlow<Context>(NeutralContext())
    val context: StateFlow<Context> = _context

    override fun invoke(event: Event) {
        logger.d("#invoke args : event=$event")

        val notebook = _notebook.value
        val context = _context.value
        logger.d("#invoke : notebook=$notebook, context=$context")
        when {
            event is ActivateEvent && context is NeutralContext -> launch {
                val target = notebook.objects.firstOrNull { event.target == it.id }
                if (null == target) {
                    logger.w("#invoke target not found : targetId=${event.target}")
                    return@launch
                }

                _context.emit(context.activate(target))
            }

            event is ActivateEvent && context is ObjectActivatedContext -> launch {
                val target = notebook.objects.firstOrNull { event.target == it.id }
                if (null == target || target == context.active) {
                    logger.w("#invoke target not found or not active : targetId=${event.target}, active=${context.active}")
                    return@launch
                }

                _context.emit(context.switch(target))
            }

            event is AddAnchorEvent && context is NotebookMenuContext -> launch {
                val anchor = AnchorState(x = event.x, y = event.y)

                _notebook.emit(notebook.copy(objects = notebook.objects + anchor))
                _context.emit(context.activate(anchor))
            }

            event is AddNodeEvent && context is NotebookMenuContext -> launch {
                val node = NodeState(x = event.x, y = event.y)
                _notebook.emit(notebook.copy(objects = notebook.objects + node))
                _context.emit(context.activate(node))
            }

            event is DeactivateEvent && context is ObjectActivatedContext -> launch {
                _context.emit(context.neutral())
            }

            event is HideContextMenuEvent && context is NotebookMenuContext -> launch {
                _context.emit(context.neutral())
            }

            event is MoveEvent && context is NeutralContext -> launch {
                val target = notebook.objects.firstOrNull { event.target == it.id }
                when (target) {
                    null -> {
                        logger.w("#invoke target not found : targetId=${event.target}")
                        return@launch
                    }

                    is AnchorState -> {
                        target.x = event.x
                        target.y = event.y
                    }

                    is NodeState -> {
                        target.x = event.x
                        target.y = event.y
                    }

                    else -> logger.w("#invoke unsupported target type : $target")
                }
            }

            event is ShowNotebookContextMenuEvent && context is NeutralContext -> launch {
                _context.emit(context.menu(event.x, event.y))
            }

            event is UpdateNodeTextEvent && context is ObjectEditContext -> launch {
                val target = notebook.objects.firstOrNull { event.target == it.id } as? NodeState
                if (null == target || target != context.active) {
                    logger.w("#invoke target not found or not active : targetId=${event.target}, active=${context.active}")
                    return@launch
                }
            }

            else ->
                logger.w("#invoke unsupported event : $event")
        }

        logger.d("#invoke completed : this=$this")
    }

    override fun toString() = listOf(
        "notebook=${_notebook.value}",
        "context=${_context.value}"
    ).joinToString(", ", "$tag(", ")")
}