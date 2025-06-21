package kr.lul.stringnotebook.viewmodel.organism

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
            is ActivateEvent -> _context.update { current ->
                val target = _notebook.value.objects.firstOrNull { event.target == it.id }
                current.copy(active = target)
            }

            is AddAnchorEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value

                val anchor = AnchorState(x = event.x, y = event.y)
                logger.d("#invoke : anchor=$anchor")

                _notebook.emit(notebook.copy(objects = notebook.objects + anchor))
                _context.emit(
                    context.copy(
                        active = anchor,
                        menu = null
                    )
                )
            }

            is AddNodeEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value

                val node = NodeState(x = event.x, y = event.y)
                val objects = notebook.objects + node
                logger.d("#invoke : node=$node, objects=$objects")

                _notebook.emit(notebook.copy(objects = objects))
                _context.emit(
                    context.copy(
                        active = node,
                        menu = null
                    )
                )
            }

            is HideContextMenuEvent -> _context.update {
                it.copy(
                    active = null,
                    menu = null
                )
            }

            is MoveEvent -> viewModelScope.launch {
                logger.d("event=$event")
                val notebook = _notebook.value
                val context = _context.value

                val objects = notebook.objects.toMutableList()
                logger.d("before : $objects")

                val target = objects.firstOrNull { event.target == it.id }
                    ?: return@launch
                val index = objects.indexOf(target)
                val next = when (target) {
                    is AnchorState -> target.copy(
                        x = event.x,
                        y = event.y
                    )

                    is NodeState -> target.copy(
                        x = event.x,
                        y = event.y
                    )

                    else ->
                        return@launch
                }

                objects[index] = next
                logger.d("after : $objects")

                _notebook.emit(notebook.copy(objects = objects))
                _context.emit(context.copy(active = next))
            }

            is ShowContextMenuEvent -> _context.update { current ->
                val notebook = _notebook.value
                val target = notebook.objects.firstOrNull { event.target == it.id }

                current.copy(
                    active = target,
                    menu = MenuState(event.x, event.y, target)
                )
            }

            is UpdateNodeTextEvent -> viewModelScope.launch {
                val notebook = _notebook.value
                val context = _context.value

                val objects = notebook.objects.toMutableList()
                val target = objects.firstOrNull { event.target == it.id } as? NodeState
                    ?: return@launch

                val next = target.copy(text = event.text)
                objects[objects.indexOf(target)] = next

                _notebook.emit(notebook.copy(objects))
                _context.emit(context.copy(active = next))
            }

            else ->
                logger.w("#invoke unsupported event : $event")
        }
    }
}