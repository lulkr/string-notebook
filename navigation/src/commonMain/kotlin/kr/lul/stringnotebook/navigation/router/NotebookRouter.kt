package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.lul.stringnotebook.navigation.compose.baseViewModel
import kr.lul.stringnotebook.navigation.navigator.NotebookNavigator
import kr.lul.stringnotebook.ui.page.NotebookPage
import kr.lul.stringnotebook.viewmodel.page.NotebookPageViewModel
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Composable
fun NotebookRouter(
    navigator: NotebookNavigator,
    viewModel: NotebookPageViewModel = baseViewModel()
) {
    logger.v("#NotebookRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsStateWithLifecycle()

    NotebookPage(
        state = state,
        handler = viewModel
    )
}