package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.ShowNotebookContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * [NeutralContext] 상태의 이벤트 처리기.
 */
@ExperimentalUuidApi
class NeutralContextEventProcessor(tag: String) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: NeutralContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is ActivateEvent ->
                handle(notebook, context, event, callback)

            is ShowNotebookContextMenuEvent ->
                handle(notebook, context, event, callback)

            else ->
                throw IllegalArgumentException("Unsupported event for NeutralContextNotebookViewModelet: event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    private fun handle(
        notebook: NotebookState,
        context: NeutralContext,
        event: ActivateEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        if (null == target) {
            logger.w("#invoke target not found : targetId=${event.target}")
            return
        }

        callback(notebook, context.activate(target))
    }

    private fun handle(
        notebook: NotebookState,
        context: NeutralContext,
        event: ShowNotebookContextMenuEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        callback(notebook, context.menu(event.x, event.y))
    }
}