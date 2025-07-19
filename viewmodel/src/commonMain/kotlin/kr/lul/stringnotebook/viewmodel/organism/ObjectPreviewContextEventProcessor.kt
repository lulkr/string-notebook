package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.EndMoveObjectEvent
import kr.lul.stringnotebook.domain.event.MovePreviewEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectPreviewContext
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class ObjectPreviewContextEventProcessor(
    tag: String
) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")
        when (event) {
            is EndMoveObjectEvent -> handle(notebook, context, event, callback)
            is MovePreviewEvent -> handle(notebook, context, event, callback)
            else -> {}
            //throw IllegalArgumentException("unsupported event: ${event::class.qualifiedName}, event=$event")
        }
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: EndMoveObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "target object not found: event.target=${event.target}" }
        require(target == context.target) { "target does not match : event.target=${event.target}, context.target=${context.target}" }

        val preview = when (target) {
            is AnchorState ->
                requireNotNull(target.preview) { "anchor preview not found: target=$target" }

            else ->
                throw IllegalArgumentException("unsupported target type : target::class=${target::class.qualifiedName}")
        }

        target.x = preview.x
        target.y = preview.y
        target.preview = null


        callback(
            notebook.copy(objects = notebook.objects.filterNot { it.id == preview.id }),
            context.focus(target)
        )
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: MovePreviewEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "Target object not found: event.target=${event.target}" }

        val preview = when (target) {
            is AnchorState ->
                requireNotNull(target.preview) { "anchor preview not found : target=$target" }

            else ->
                throw IllegalArgumentException("unsupported target type : target::class=${target::class.qualifiedName}")

        }
        preview.x = event.x
        preview.y = event.y

        callback(notebook, context)
    }
}