package kr.lul.stringnotebook.viewmodel.template

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.anchor.AnchorImpl
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.foundation.StringNotebook
import kr.lul.stringnotebook.domain.notebook.StringNotebookImpl
import kr.lul.stringnotebook.state.atom.Res
import kr.lul.stringnotebook.state.atom.domain_notebook_id_default
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookState
import org.jetbrains.compose.resources.getString
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class NotebookViewModelet(
    private val scope: CoroutineScope
) : EventProcessor {
    private val logger = Logger("NotebookViewModelet")

    var notebook: StringNotebook? = null
        private set

    private val _state = MutableStateFlow<NotebookState?>(null)
    val state: StateFlow<NotebookState?> = _state

    init {
        scope.launch {
            notebook = StringNotebookImpl(name = getString(Res.string.domain_notebook_id_default))

            _state.emit(
                NotebookState(
                    anchors = notebook!!.anchors
                        .map { AnchorState(it.id, it.x, it.y) }
                )
            )
        }
    }

    override fun invoke(event: Event, timestamp: Instant) {
        logger.d("#invoke args : event=$event, timestamp=$timestamp")

        if (notebook == null) {
            logger.w("#invoke notebook is null : event=$event")
            return
        }

        when (event) {
            is AddAnchorEvent ->
                handle(event, timestamp)

            else ->
                logger.e("#invoke unsupported event : $event")
        }
    }

    fun handle(event: AddAnchorEvent, timestamp: Instant) {
        val anchor = AnchorImpl(Uuid.random(), event.anchorType, event.x, event.y)
        notebook!!.add(anchor)

        _state.update { current ->
            current?.copy(
                anchors = current.anchors + AnchorState(anchor.id, anchor.x, anchor.y)
            )
        }
    }

    override fun toString() = listOf(
        "notebook=${notebook}",
        "_state=${_state.value}"
    ).joinToString(", ", "NotebookViewModelet(", ")")
}