package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import kr.lul.stringnotebook.state.page.SplashPageHandler
import kr.lul.stringnotebook.state.page.SplashPageState.Success
import kr.lul.stringnotebook.ui.page.SplashPage
import kr.lul.stringnotebook.viewmodel.page.SplashViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashRouter(
    navigator: SplashNavigator,
    viewModel: SplashViewModel = koinViewModel()
) {
    logger.v("#SplashRouter args : navigator=$navigator")

    val state by viewModel.state.collectAsState()
    val handler = remember(navigator, viewModel) {
        object : SplashPageHandler {
        }
    }

    LaunchedEffect(navigator, viewModel, state) {
        when (state) {
            is Success ->
                navigator.main()

            else -> {}
        }
    }

    SplashPage(state, handler)
}