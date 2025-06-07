package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.state.template.MainNotebookMenuHandler
import kr.lul.stringnotebook.ui.page.MainPage
import kr.lul.stringnotebook.viewmodel.page.MainViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainRouter(
    navigator: MainNavigator,
    viewModel: MainViewModel = koinViewModel()
) {
    logger.v("#MainRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsState()
    val handler = remember(navigator, viewModel) {
        object : MainPageHandler by MainPageHandler.NoOp {
            override val notebook: MainNotebookMenuHandler = object : MainNotebookMenuHandler {
                override fun onClickNewNotebook() {
                    navigator.notebook()
                }
            }
        }
    }

    MainPage(state, handler)
}