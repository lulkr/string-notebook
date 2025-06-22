package kr.lul.stringnotebook.viewmodel.organism

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.event.AddNodeEvent
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.event.ShowContextMenuEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.NotebookContextImpl
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class MainPaneViewModel(
    initState: NotebookState
) : ViewModel(), EventProcessor {
    private val logger = Logger("MainPaneViewModel")

    private val _notebook = MutableStateFlow(initState)
    val notebook: StateFlow<NotebookState> = _notebook

    private val _context = MutableStateFlow(NotebookContextImpl())
    val context: StateFlow<NotebookContext> = _context

    override fun invoke(event: Event) {
        logger.d("#invoke args : event=$event")

        when (event) {
            is ActivateEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value
                val target = notebook.objects.firstOrNull { event.target == it.id }

                context.active = target
                _context.emit(context)
            }

            is AddAnchorEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value

                val anchor = AnchorState(x = event.x, y = event.y)
                context.active = anchor
                context.menu = null

                _notebook.emit(notebook.copy(objects = notebook.objects + anchor))
                _context.emit(context)
            }

            is AddNodeEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value

                val node = NodeState(x = event.x, y = event.y)
                context.active = node
                context.menu = null

                _notebook.emit(notebook.copy(objects = notebook.objects + node))
                _context.emit(context)
            }

            is HideContextMenuEvent -> viewModelScope.launch {
                val context = _context.value
                context.active = null
                context.menu = null

                _context.emit(context)
            }

            is MoveEvent -> viewModelScope.launch {
                logger.d("event=$event")
                val notebook = _notebook.value

                val target = notebook.objects.firstOrNull { event.target == it.id }
                    ?: return@launch

                when (target) {
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

            is ShowContextMenuEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value
                val target = notebook.objects.firstOrNull { event.target == it.id }

                context.active = target
                context.menu = MenuState(event.x, event.y, target)
                _context.emit(context)
            }

            is UpdateNodeTextEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value
                val target = notebook.objects.firstOrNull { event.target == it.id } as? NodeState
                    ?: return@launch

                target.text = event.text
            }

            else ->
                logger.w("#invoke unsupported event : $event")
        }
    }
}