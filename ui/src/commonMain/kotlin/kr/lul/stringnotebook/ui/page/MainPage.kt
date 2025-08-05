package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.state.page.MainPageState
import kr.lul.stringnotebook.ui.template.notebook.NotebookList
import kotlin.uuid.ExperimentalUuidApi

/**
 * `MainPage`
 *
 * - [Figma 디자인](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/String-Notebook-UI?node-id=1-7)
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun MainPage(
    state: MainPageState,
    handler: MainPageHandler
) {
    logger.v("#MainPage args : state=$state, handler=$handler")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        NotebookList()
    }
}