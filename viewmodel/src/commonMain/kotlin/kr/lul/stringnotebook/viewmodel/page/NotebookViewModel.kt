package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.state.page.NotebookPageState

class NotebookViewModel(
    private val handle: SavedStateHandle
) : ViewModel() {
    private val _state = MutableStateFlow(NotebookPageState())
    val state: StateFlow<NotebookPageState> = _state

    override fun toString() = listOf(
        "handle=${handle}",
        "state=$state"
    ).joinToString(", ", "NotebookViewModel(", ")")
}