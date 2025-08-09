package kr.lul.stringnotebook.viewmodel.page

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class NotebookPageViewModel(
    initState: NotebookPageState = NotebookPageState.Loading(NotebookState.Placeholder.id)
) : BaseViewModel("NotebookPageViewModel") {
    val state: StateFlow<NotebookPageState> = MutableStateFlow(initState)

    init {
        logger.i("#init : state=${state.value}")
    }

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}