package kr.lul.stringnotebook.ui.page

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.state.page.MainPageState
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun MainPage(
    state: MainPageState,
    handler: MainPageHandler
) {
    logger.v("#MainPage args : state=$state, handler=$handler")
}