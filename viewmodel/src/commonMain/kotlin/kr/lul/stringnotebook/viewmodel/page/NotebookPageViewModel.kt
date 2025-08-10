package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kr.lul.stringnotebook.state.page.ComponentsMode.ALL
import kr.lul.stringnotebook.state.page.ComponentsMode.HIDE_OVERLAY
import kr.lul.stringnotebook.state.page.ComponentsMode.NOTEBOOK_ONLY
import kr.lul.stringnotebook.state.page.NotebookPageHandler
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kr.lul.stringnotebook.viewmodel.organism.NotebookViewModelet
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class NotebookPageViewModel(
    model: NotebookModel,
    initState: NotebookPageState.Loading = NotebookPageState.Loading(NotebookState.Placeholder.id)
) : BaseViewModel("NotebookPageViewModel"), NotebookPageHandler {
    private val _notebook = NotebookViewModelet(
        parent = this,
        tag = "${tag}.notebook",
        model = model,
        id = initState.id
    )

    private val _componentsMode = MutableStateFlow(ALL)

    val state: StateFlow<NotebookPageState> = combine(
        _notebook.state,
        _componentsMode
    ) { notebook, componentMode ->
        val next = if (notebook == null) {
            NotebookPageState.Loading(initState.id)
        } else {
            NotebookPageState.Editing(
                notebook = notebook,
                componentsMode = componentMode
            )
        }
        logger.d("#state : $notebook => $next")
        next
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), initState)

    init {
        logger.i("#init : state=${state.value}")
    }

    override fun onClickNotebook() {
        logger.d("#onClickNotebook called.")

        _componentsMode.update { current ->
            when (current) {
                ALL -> HIDE_OVERLAY
                HIDE_OVERLAY -> NOTEBOOK_ONLY
                NOTEBOOK_ONLY -> ALL
            }
        }
    }

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}