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
import kr.lul.stringnotebook.state.page.NotebookPageHandler
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.state.template.FullLayoutState
import kr.lul.stringnotebook.state.template.LayoutHandler
import kr.lul.stringnotebook.state.template.LayoutState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kr.lul.stringnotebook.viewmodel.organism.NotebookViewModelet
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class NotebookPageViewModel(
    model: NotebookModel,
    initState: NotebookPageState.Loading = NotebookPageState.Loading(NotebookState.Placeholder.id)
) : BaseViewModel("NotebookPageViewModel"), NotebookPageHandler {
    private val _layout = MutableStateFlow<LayoutState>(FullLayoutState())
    override val layout: LayoutHandler = object : LayoutHandler {
        override fun onChangeLayout() {
            logger.d("#layout.onChangeLayout called.")

            _layout.update { current ->
                current.next
            }
        }
    }

    private val _notebook = NotebookViewModelet(
        parent = this,
        tag = "${tag}.notebook",
        model = model,
        id = initState.id
    )

    val state: StateFlow<NotebookPageState> = combine(
        _layout,
        _notebook.state
    ) { layout, notebook ->
        val next = if (notebook == null) {
            NotebookPageState.Loading(initState.id)
        } else {
            NotebookPageState.Editing(
                notebook = notebook,
                layout = layout,
            )
        }
        logger.d("#state : $notebook => $next")
        next
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), initState)

    init {
        logger.i("#init : state=${state.value}")
    }

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}