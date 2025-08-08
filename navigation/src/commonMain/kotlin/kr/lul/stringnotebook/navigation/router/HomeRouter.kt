package kr.lul.stringnotebook.navigation.router

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.lul.stringnotebook.navigation.compose.baseViewModel
import kr.lul.stringnotebook.navigation.navigator.HomeNavigator
import kr.lul.stringnotebook.state.molecule.ButtonHandler
import kr.lul.stringnotebook.state.page.HomePageHandler
import kr.lul.stringnotebook.state.template.notebook.NotebookListHandler
import kr.lul.stringnotebook.ui.page.HomePage
import kr.lul.stringnotebook.viewmodel.page.HomePageViewModel
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 홈 화면의 각 MVVM 요소를 연결한다.
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun HomeRouter(
    navigator: HomeNavigator,
    viewModel: HomePageViewModel = baseViewModel()
) {
    logger.v("#HomeRouter args : navigator=$navigator, viewModel=$viewModel")

    val state by viewModel.state.collectAsStateWithLifecycle()

    val handler = remember(navigator, viewModel) {
        object : HomePageHandler {
            override val list: NotebookListHandler = object : NotebookListHandler {
                override val new: ButtonHandler = object : ButtonHandler {
                    override fun onClick() {
                        logger.d("#HomeRouter.handler.list.new.onClick called.")

                        viewModel.newNotebook {
                            logger.d("#HomeRouter.handler.list.new.onClick.callback called.")
                        }
                    }
                }

                override fun onClickOpen(id: Uuid) {
                    logger.d("#HomeRouter.handler.list.onClickOpen args : id=$id")
                    navigator.notebook(id)
                }
            }
        }
    }

    HomePage(state, handler)
}