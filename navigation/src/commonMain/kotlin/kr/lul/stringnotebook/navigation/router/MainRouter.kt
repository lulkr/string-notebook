package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.lul.stringnotebook.navigation.compose.baseViewModel
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.ui.page.MainPage
import kr.lul.stringnotebook.viewmodel.page.MainPageViewModel
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun MainRouter(
    navigator: MainNavigator,
    viewModel: MainPageViewModel = baseViewModel()
) {
    logger.v("#MainRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsStateWithLifecycle()

    MainPage(state, MainPageHandler.NoOp)
}