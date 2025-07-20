package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.FocusObjectEvent
import kr.lul.stringnotebook.domain.event.OpenEditorEvent
import kr.lul.stringnotebook.domain.event.StartMoveObjectEvent
import kr.lul.stringnotebook.domain.event.UnfocusObjectEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
import kr.lul.stringnotebook.state.organism.PreviewAnchorState
import kr.lul.stringnotebook.state.organism.PreviewNodeState
import kotlin.uuid.ExperimentalUuidApi

/**
 * [ObjectFocusedContext] 상태의 이벤트 처리기.
 */
@ExperimentalUuidApi
class ObjectFocusedContextEventProcessor(tag: String) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectFocusedContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is FocusObjectEvent -> handle(notebook, context, event, callback)
            is OpenEditorEvent -> handle(notebook, context, event, callback)
            is StartMoveObjectEvent -> handle(notebook, context, event, callback)
            is UnfocusObjectEvent -> callback(notebook, context.notebook())

            else ->
                throw IllegalArgumentException("Unsupported event : event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectFocusedContext,
        event: FocusObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        if (null == target || target == context.obj) {
            logger.w("#handle target not found or not focused : event.target=${event.target}, object=${context.obj}")
            return
        }

        callback(notebook, context.switch(target))
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectFocusedContext,
        event: OpenEditorEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        when (target) {
            null -> {
                logger.e("#handle target not found : targetId=${event.target}")
                return
            }

            !is NodeState -> {
                logger.e("#handle target is not NodeState : target=$target")
                return
            }
        }

        callback(notebook, context.edit())
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectFocusedContext,
        event: StartMoveObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "target not found : event.target=${event.target}" }
        require(target == context.obj) { "target is not focused : event.target=${event.target}, object=${context.obj}" }
        require(target is AnchorState || target is NodeState) { "unsupported target type : target::class=${target::class.qualifiedName}" }

        val preview = when (target) {
            is AnchorState ->
                PreviewAnchorState(target, target.x, target.y)

            is NodeState ->
                PreviewNodeState(target, target.x, target.y)

            else -> throw IllegalArgumentException("unsupported target type : target::class=${target::class.qualifiedName}")
        }

        callback(notebook.copy(objects = notebook.objects + preview), context.preview(target))
    }
}