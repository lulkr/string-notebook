package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.viewmodel.template.NotebookViewModelet

class NotebookPageViewModel(
    private val handle: SavedStateHandle
) : ViewModel() {
    private val logger = Logger("NotebookPageViewModel")
    val notebook = NotebookViewModelet(viewModelScope)

    private val dummy = MutableStateFlow("")

    val state: StateFlow<NotebookPageState> = combine(notebook.state, dummy) { notebook, _ ->
        if (null == notebook) {
            NotebookPageState.Loading
        } else {
            NotebookPageState.Editing(notebook = notebook)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), NotebookPageState.Initial)


    override fun toString() = listOf(
        "handle=${handle}",
        "notebook=${notebook}",
        "state=${state.value}"
    ).joinToString(", ", "${logger.name}(", ")")
}