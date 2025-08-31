package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.lul.stringnotebook.navigation.compose.baseViewModel
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import kr.lul.stringnotebook.state.page.SplashPageHandler
import kr.lul.stringnotebook.state.page.SplashPageState.Success
import kr.lul.stringnotebook.ui.page.SplashPage
import kr.lul.stringnotebook.viewmodel.page.SplashPageViewModel
import kotlin.uuid.ExperimentalUuidApi

/**
 * 스플래시 화면의 각 MVVM 요소를 연결한다.
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun SplashRouter(
    navigator: SplashNavigator,
    viewModel: SplashPageViewModel = baseViewModel()
) {
    logger.v("#SplashRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsStateWithLifecycle()
    val handler = remember(navigator, viewModel) {
        object : SplashPageHandler {
        }
    }

    val scope = rememberCoroutineScope()
    LaunchedEffect(navigator, viewModel, state) {
        when (state) {
            is Success -> scope.launch {
                delay(753L)
                navigator.home()
            }

            else -> {}
        }
    }

    SplashPage(state, handler)
}