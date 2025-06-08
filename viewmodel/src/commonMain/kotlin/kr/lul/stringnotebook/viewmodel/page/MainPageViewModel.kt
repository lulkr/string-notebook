package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.atom.Res.string
import kr.lul.stringnotebook.state.atom.name
import kr.lul.stringnotebook.state.atom.template_welcome_default
import kr.lul.stringnotebook.state.page.MainPageState
import org.jetbrains.compose.resources.getString

class MainPageViewModel : ViewModel() {
    private val logger = Logger("MainPageViewModel")

    private val _state = MutableStateFlow(MainPageState()) // TODO 초기 상태 설정
    val state: StateFlow<MainPageState> = _state

    init {
        viewModelScope.launch {
            val current = _state.value
            _state.emit(
                current.copy(
                    welcome = current.welcome.copy(getString(string.template_welcome_default, getString(string.name)))
                )
            )
        }
    }

    override fun toString() = listOf(
        "state=${_state.value}"
    ).joinToString(", ", "${logger.name}(", ")")
}
