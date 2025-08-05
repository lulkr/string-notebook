package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.lul.stringnotebook.navigation.compose.baseViewModel
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.state.molecule.ButtonHandler
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.state.template.notebook.NotebookListHandler
import kr.lul.stringnotebook.ui.page.MainPage
import kr.lul.stringnotebook.viewmodel.page.MainPageViewModel
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun MainRouter(
    navigator: MainNavigator,
    viewModel: MainPageViewModel = baseViewModel()
) {
    logger.v("#MainRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsStateWithLifecycle()

    val handler = remember(navigator, viewModel) {
        object : MainPageHandler {
            override val list: NotebookListHandler = object : NotebookListHandler {
                override val new: ButtonHandler = object : ButtonHandler {
                    override fun onClick() {
                        logger.d("#MainRouter.handler.list.new.onClick called.")
                    }
                }

                override fun onClickOpen(id: Uuid) {
                    logger.d("#MainRouter.handler.list.onClickOpen args : id=$id")
                    navigator.notebook(id)
                }
            }
        }
    }

    MainPage(state, handler)
}