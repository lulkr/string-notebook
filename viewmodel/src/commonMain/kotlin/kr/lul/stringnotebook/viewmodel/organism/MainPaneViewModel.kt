package kr.lul.stringnotebook.viewmodel.organism

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.ShowContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.NotebookContextImpl
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

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
            is HideContextMenuEvent -> _context.update {
                it.copy(
                    active = null,
                    menu = null
                )
            }

            is ShowContextMenuEvent -> _context.update { current ->
                val notebook = _notebook.value
                val target = notebook.objects.firstOrNull { event.target == it.id }

                current.copy(
                    active = target,
                    menu = MenuState(event.x, event.y, target)
                )
            }

            else ->
                logger.w("#invoke unsupported event : $event")
        }
    }
}