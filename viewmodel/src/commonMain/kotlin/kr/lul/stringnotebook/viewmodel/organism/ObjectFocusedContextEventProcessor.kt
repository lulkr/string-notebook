package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.DeactivateEvent
import kr.lul.stringnotebook.domain.event.ObjectFocusEvent
import kr.lul.stringnotebook.domain.event.OpenEditorEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
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
            is ObjectFocusEvent -> handle(notebook, context, event, callback)

            is DeactivateEvent -> callback(notebook, context.notebook())

            is OpenEditorEvent -> handle(notebook, context, event, callback)

            else ->
                throw IllegalArgumentException("Unsupported event : event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectFocusedContext,
        event: ObjectFocusEvent,
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
}