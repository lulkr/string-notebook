package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.FocusObjectEvent
import kr.lul.stringnotebook.domain.event.OpenEditorEvent
import kr.lul.stringnotebook.domain.event.UnfocusObjectEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectEditContext
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class ObjectEditContextEventProcessor {
    private val logger = Logger("ObjectEditContextEventProcessor")

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")

        when (event) {
            is FocusObjectEvent -> handle(notebook, context, event, callback)

            is UnfocusObjectEvent -> callback(notebook, context.notebook())

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
        event: FocusObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        when {
            null == target -> {
                logger.e("#handle target not found : event=$event")
                return
            }
        }

        callback(notebook, context.focus(target))
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

        callback(notebook, context.edit(target))
    }

    private fun handle(
        notebook: NotebookState,
        context: ObjectEditContext,
        event: UpdateNodeTextEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "target not found : event.target=${event.target}" }
        require(target is NodeState) { "unsupported target type : target::class=${target::class.qualifiedName}" }
        require(target == context.obj) { "target is not focused : event.target=${event.target}, focused=${context.obj}" }

        target.text = event.text
        callback(notebook, context)
    }
}