package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.page.MainPageState

class MainViewModel : ViewModel() {
    private val logger = Logger("MainViewModel")

    private val _state = MutableStateFlow(MainPageState("String Notebook")) // 초기 상태 설정
    val state: StateFlow<MainPageState> = _state

    override fun toString() = listOf(
        "state=${_state.value}"
    ).joinToString(", ", "MainViewModel(", ")")
}
