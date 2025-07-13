package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.ShowNotebookContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NotebookFocusedContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * [NotebookFocusedContext] 상태의 이벤트 처리기.
 */
@ExperimentalUuidApi
class NotebookFocusedContextEventProcessor(tag: String) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: NotebookFocusedContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is ActivateEvent ->
                handle(notebook, context, event, callback)

            is ShowNotebookContextMenuEvent -> callback(notebook, context.menu(event.x, event.y))

            else -> {}
            //throw IllegalArgumentException("Unsupported event : event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    private fun handle(
        notebook: NotebookState,
        context: NotebookFocusedContext,
        event: ActivateEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        if (null == target) {
            logger.w("#invoke target not found : targetId=${event.target}")
            return
        }

        callback(notebook, context.focus(target))
    }
}