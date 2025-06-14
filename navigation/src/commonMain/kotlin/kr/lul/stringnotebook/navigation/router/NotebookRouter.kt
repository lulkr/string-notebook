package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kr.lul.stringnotebook.navigation.navigator.NotebookNavigator
import kr.lul.stringnotebook.ui.page.NotebookPage
import kr.lul.stringnotebook.viewmodel.page.NotebookPageViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NotebookRouter(
    navigator: NotebookNavigator,
    viewModel: NotebookPageViewModel = koinViewModel()
) {
    logger.v("#NotebookRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsState()

        NotebookPage(state)
}