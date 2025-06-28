package kr.lul.stringnotebook.viewmodel.page

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.lul.stringnotebook.state.page.SplashPageState
import kr.lul.stringnotebook.state.page.SplashPageState.InProgress
import kr.lul.stringnotebook.state.page.SplashPageState.Init
import kr.lul.stringnotebook.state.page.SplashPageState.Success
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.name
import kr.lul.stringnotebook.viewmodel.atom.BaseViewModel
import org.jetbrains.compose.resources.getString
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class SplashPageViewModel : BaseViewModel("SplashPageViewModel") {
    private val _state = MutableStateFlow<SplashPageState>(Init)
    val state: StateFlow<SplashPageState> = _state

    init {
        viewModelScope.launch { // TODO 삭제.
            val name = getString(Res.string.name)
            logger.d("#init resource test : $name")
        }

        viewModelScope.launch {
            _state.emit(InProgress)

            delay(2000L)
            _state.emit(Success)
//            _state.emit(SplashPageState.Fail(RuntimeException("Test Exception")))
        }
    }

    override fun toString() = listOf(
        "state=${_state.value}"
    ).joinToString(", ", "SplashViewModel(", ")")
}
