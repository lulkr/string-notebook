package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.page.NotebookPageHandler
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.page_notebook_loading_label
import org.jetbrains.compose.resources.stringResource
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 화면.
 *
 * @param state 노트북 편집 화면의 상태.
 * @param handler 사용자의 노트북 조작 핸들러.
 */
@Composable
@ExperimentalUuidApi
fun NotebookPage(
    state: NotebookPageState,
    handler: NotebookPageHandler = NotebookPageHandler.NoOp
) {
    logger.v("#NotebookPage args : state=$state, handler=$handler")

    when (state) {
        is NotebookPageState.Loading ->
            NotebookPageLoading(state, handler)

        is NotebookPageState.Editing ->
            NotebookPageEditing(state, handler)
    }
}

@Composable
@ExperimentalUuidApi
fun NotebookPageLoading(state: NotebookPageState.Loading, handler: NotebookPageHandler) {
    Column(Modifier.fillMaxSize()) {
        LinearProgressIndicator(Modifier.fillMaxWidth())
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(Res.string.page_notebook_loading_label))
        }
    }
}

@Composable
@ExperimentalUuidApi
fun NotebookPageEditing(state: NotebookPageState.Editing, handler: NotebookPageHandler) {
    Text("$state")
}
