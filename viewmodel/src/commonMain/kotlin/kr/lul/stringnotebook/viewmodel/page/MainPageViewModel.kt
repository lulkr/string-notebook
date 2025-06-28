package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.page.MainPageState
import kr.lul.stringnotebook.viewmodel.organism.MainPaneViewModel
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class MainPageViewModel(
    initState: MainPageState = MainPageState()
) : ViewModel() {
    private val logger = Logger("MainViewModel")

    private val _notebook = MainPaneViewModel(initState.notebook)

    val state: StateFlow<MainPageState> = combine(_notebook.notebook, _notebook.context) { notebook, context ->
        val next = MainPageState(notebook, context, _notebook)
        logger.v("#state : next=$next")
        next
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), initState)

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "MainViewModel(", ")")
}
