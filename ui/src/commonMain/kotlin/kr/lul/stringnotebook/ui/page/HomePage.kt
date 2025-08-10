package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.page.HomePageHandler
import kr.lul.stringnotebook.state.page.HomePageState
import kr.lul.stringnotebook.ui.template.NotebookList
import kotlin.uuid.ExperimentalUuidApi

/**
 * `HomePage`
 *
 * - [Figma 디자인](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/String-Notebook-UI?node-id=1-7)
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun HomePage(
    state: HomePageState,
    handler: HomePageHandler = HomePageHandler.NoOp
) {
    logger.v("#HomePage args : state=$state, handler=$handler")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NotebookList(handler.list)
    }
}