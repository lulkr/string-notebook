package kr.lul.stringnotebook.viewmodel.template

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.foundation.StringNotebook
import kr.lul.stringnotebook.domain.notebook.StringNotebookImpl
import kr.lul.stringnotebook.model.EventProcessorImpl
import kr.lul.stringnotebook.state.atom.Res
import kr.lul.stringnotebook.state.atom.domain_notebook_id_default
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookState
import org.jetbrains.compose.resources.getString
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
class NotebookViewModelet(
    private val scope: CoroutineScope
) {
    var notebook: StringNotebook? = null
        private set

    var eventProcessor: EventProcessor? = null
        private set

    private val _state = MutableStateFlow<NotebookState?>(null)
    val state: StateFlow<NotebookState?> = _state

    init {
        scope.launch {
            notebook = StringNotebookImpl(name = getString(Res.string.domain_notebook_id_default))
            eventProcessor = EventProcessorImpl(notebook!!)

            _state.emit(
                NotebookState(
                    anchors = notebook!!.anchors
                        .map { AnchorState(it.id, it.x, it.y) }
                )
            )
        }
    }

    override fun toString() = listOf(
        "notebook=${notebook}",
        "_state=${_state.value}"
    ).joinToString(", ", "NotebookViewModelet(", ")")
}