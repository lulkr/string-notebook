package kr.lul.stringnotebook.viewmodel.organism

import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.atom.TextResource
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.state.organism.MenuItemState
import kr.lul.stringnotebook.state.organism.MenuState
import kr.lul.stringnotebook.state.organism.NotebookHandler
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.molecule_context_menu_add_anchor
import kr.lul.stringnotebook.state.template.LayoutHandler
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModelet
import kr.lul.stringnotebook.viewmodel.foundation.ViewModeletOwner
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
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

    override fun onClick(offset: Offset) {
        logger.d("#onClick args : offset=$offset")

        // TODO FSM 상태에 따른 동작 정의.

        val state = this.state.value
        if (state?.menu != null) {
            state.menu = null
        } else {
            layoutHandler.onChangeLayout()
        }
    }

    override fun onDoubleClick(offset: Offset) = onLongClick(offset)

    override fun onLongClick(offset: Offset) {
        logger.d("#onLongClick args : offset=$offset")

        val state = this.state.value
        if (state == null)
            throw IllegalStateException("Notebook state is not initialized yet.")

        state.menu = MenuState(
            position = offset,
            items = listOf(
                MenuItemState(
                    label = TextState(TextResource(Res.string.molecule_context_menu_add_anchor)),
                    onClick = {
                        logger.d("#menu.items[0].onClick add anchor : offset=$offset")

                        val state = this.state.value
                        if (state == null)
                            throw IllegalStateException("Notebook state is not initialized yet.")

                        state.menu = null
                    }
                )
            ),
            key = state.key,
            testTag = state.testTag
        )
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