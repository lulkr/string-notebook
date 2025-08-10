package kr.lul.stringnotebook.viewmodel.organism

import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.organism.notebook.NotebookHandler
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kr.lul.stringnotebook.state.template.LayoutHandler
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModelet
import kr.lul.stringnotebook.viewmodel.foundation.ViewModeletOwner
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
class NotebookViewModelet(
    parent: ViewModeletOwner,
    tag: String,
    private val layoutHandler: LayoutHandler,
    private val model: NotebookModel,
    val id: Uuid
) : BaseViewModelet(parent, tag), NotebookHandler {
    private lateinit var notebook: Notebook

    private val _state: MutableStateFlow<NotebookState?> = MutableStateFlow(null)
    val state: StateFlow<NotebookState?> = _state

    override fun onClickBackground() {
        logger.d("#onClickBackground called.")

        // TODO FSM 상태에 따른 동작 정의.

        layoutHandler.onChangeLayout()
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        launch {
            notebook = model.read(id)
                ?: throw IllegalArgumentException("Notebook not found : id=$id")
            _state.emit(notebook.state)
        }
    }

    override fun toString() = listOf(
        "id=$id",
        "state=${state.value}"
    ).joinToString(", ", "NotebookViewModelet(", ")")
}