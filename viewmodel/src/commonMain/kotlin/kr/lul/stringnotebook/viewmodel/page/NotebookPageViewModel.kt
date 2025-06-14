package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.page.NotebookPageState

class NotebookPageViewModel(
    private val handle: SavedStateHandle
) : ViewModel() {
    private val logger = Logger("NotebookPageViewModel")

    private val dummy = MutableStateFlow("")

    val state: StateFlow<NotebookPageState> = MutableStateFlow(NotebookPageState.Initial)

    override fun toString() = listOf(
        "handle=${handle}"
    ).joinToString(", ", "${logger.name}(", ")")
}