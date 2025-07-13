package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.event.AddNodeEvent
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookMenuContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * [NotebookMenuContext] 상태의 이벤트 처리기.
 */
@ExperimentalUuidApi
class NotebookMenuContextEventProcessor(tag: String) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: NotebookMenuContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is AddAnchorEvent -> handle(notebook, context, event, callback)

            is AddNodeEvent -> handle(notebook, context, event, callback)

            is HideContextMenuEvent -> callback(notebook, context.notebook())

            else ->
                throw IllegalArgumentException("Unsupported event : event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    private fun handle(
        notebook: NotebookState,
        context: NotebookMenuContext,
        event: AddAnchorEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val anchor = AnchorState(x = event.x, y = event.y)

        callback(
            notebook.copy(objects = notebook.objects + anchor),
            context.focus(anchor)
        )
    }

    private fun handle(
        notebook: NotebookState,
        context: NotebookMenuContext,
        event: AddNodeEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val node = NodeState(x = event.x, y = event.y)

        callback(
            notebook.copy(objects = notebook.objects + node),
            context.focus(node)
        )
    }
}