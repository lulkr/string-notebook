package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.LinkObjectEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.LinkState
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectMenuContext
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class ObjectMenuContextEventProcessor() {
    private val logger = Logger("ObjectMenuContextEventProcessor")

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectMenuContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event")

        when (event) {
            is LinkObjectEvent -> handle(notebook, context, event, callback)
            else -> throw IllegalArgumentException("unsupported event type: event::class=${event::class.simpleName}")
        }
    }

    @Suppress("LocalVariableName")
    private fun handle(
        notebook: NotebookState,
        context: ObjectMenuContext,
        event: LinkObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val _from = notebook.objects.firstOrNull { event.from == it.id }
        requireNotNull(_from) { "from object not found: event=$event" }

        val from = when (_from) {
            is AnchorState -> _from
            is NodeState -> TODO()
            is LinkState -> TODO()
            else -> throw IllegalArgumentException("unsupported object type: object::class=${_from::class.simpleName}")
        }

        val _to = notebook.objects.firstOrNull { event.to == it.id }
        requireNotNull(_to) { "to object not found: event=$event" }

        val to = when (_to) {
            is AnchorState -> _to
            is NodeState -> TODO()
            is LinkState -> TODO()
            else -> throw IllegalArgumentException("unsupported object type: object::class=${_to::class.simpleName}")
        }

        val link = LinkState(from, to)
        val notebook = notebook.copy(notebook.objects + link)
        val context = context.focus(link)

        callback(notebook, context)
    }
}