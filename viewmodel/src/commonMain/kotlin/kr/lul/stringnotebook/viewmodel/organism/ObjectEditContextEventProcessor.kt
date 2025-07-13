package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.DeactivateEvent
import kr.lul.stringnotebook.domain.event.OpenEditorEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectEditContext
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class ObjectEditContextEventProcessor(tag: String) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is ActivateEvent -> handle(notebook, context, event, callback)

            is DeactivateEvent -> callback(notebook, context.neutral())

            is OpenEditorEvent -> handle(notebook, context, event, callback)

            is UpdateNodeTextEvent -> handle(notebook, context, event, callback)

            else -> {}
            // TODO rollback
            // throw IllegalArgumentException("Unsupported event : event::class=${event::class.qualifiedName}, event=$event")
        }
    }

    private fun handle(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: ActivateEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        when {
            null == target -> {
                logger.e("#handle target not found : event=$event")
                return
            }
        }

        callback(notebook, context.activate(target))
    }

    private fun handle(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: OpenEditorEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        when {
            null == target -> {
                logger.e("#handle target not found : event=$event")
                return
            }

            target !is NodeState -> {
                logger.e("#handle target is not NodeState : event=$event, target=$target")
                return
            }
        }

        callback(notebook, context.switch(target))
    }

    private fun handle(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: UpdateNodeTextEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        when {
            null == target -> {
                logger.e("#handle target not found : event=$event")
                return
            }

            target !is NodeState -> {
                logger.e("#handle target is not NodeState : event=$event, target=$target")
                return
            }

            target != context.active -> {
                logger.e("#handle target not match : event=$event, context.active=${context.active}")
                return
            }
        }

        target.text = event.text
        callback(notebook, context)
    }
}