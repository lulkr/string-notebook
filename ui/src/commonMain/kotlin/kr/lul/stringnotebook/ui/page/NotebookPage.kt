package kr.lul.stringnotebook.ui.page

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.page.NotebookPageHandler
import kr.lul.stringnotebook.state.page.NotebookPageState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 화면.
 *
 * @param state 노트북 편집 화면의 상태.
 * @param handler 사용자의 노트북 조작 핸들러.
 */
@ExperimentalUuidApi
@Composable
fun NotebookPage(
    state: NotebookPageState,
    handler: NotebookPageHandler = NotebookPageHandler.NoOp
) {
    logger.v("#NotebookPage args : state=$state, handler=$handler")

    Text("NotebookPage : $state")
}