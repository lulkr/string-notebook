package kr.lul.stringnotebook.viewmodel.template

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.event.MoveEvent
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
import kr.lul.stringnotebook.viewmodel.organism.NeutralContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.NotebookMenuContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.ObjectActivatedContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.ObjectEditContextEventProcessor
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class NotebookViewModelet(
    tag: String,
    page: ViewModeletOwner,
    initState: NotebookState
) : BaseViewModelet(page, tag), EventProcessor {
    internal val _notebook = MutableStateFlow(initState)
    val notebook: StateFlow<NotebookState> = _notebook

    internal val _context = MutableStateFlow<Context>(NeutralContext())
    val context: StateFlow<Context> = _context

    private val neutral = NeutralContextEventProcessor("${tag}.neutral")
    private val notebookMenu = NotebookMenuContextEventProcessor("${tag}.notebookMenu")
    private val objectActivated = ObjectActivatedContextEventProcessor("${tag}.objectActivated")
    private val objectEdit = ObjectEditContextEventProcessor("${tag}.objectEdit")

    override fun invoke(event: Event) {
        logger.d("#invoke args : event=$event")

        val notebook = _notebook.value
        val context = _context.value
        logger.d("#invoke : notebook=$notebook, context=$context")

        when (context) {
            is NeutralContext -> neutral(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is NotebookMenuContext -> notebookMenu(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is ObjectActivatedContext -> objectActivated(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is ObjectEditContext -> objectEdit(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            else -> {}
            // TODO rollback
            // throw IllegalStateException("Unsupported context for NotebookViewModelet: context::class=${context::class.qualifiedName}, context=$context")
        }

        when {
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