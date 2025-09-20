package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.page.NotebookPageHandler
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.page_notebook_loading_label
import kr.lul.stringnotebook.state.template.FullLayoutState
import kr.lul.stringnotebook.state.template.WyswygLayoutState
import kr.lul.stringnotebook.ui.organism.Notebook
import kr.lul.stringnotebook.ui.template.PropertyEditor
import kr.lul.stringnotebook.ui.template.Summary
import kr.lul.stringnotebook.ui.template.ToolBar
import org.jetbrains.compose.resources.stringResource
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 화면.
 *
 * @param state 노트북 편집 화면의 상태.
 * @param handler 사용자의 노트북 조작 핸들러.
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalTime
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
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun NotebookPageLoading(state: NotebookPageState.Loading, handler: NotebookPageHandler = NotebookPageHandler.NoOp) {
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
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun NotebookPageEditing(state: NotebookPageState.Editing, handler: NotebookPageHandler = NotebookPageHandler.NoOp) {
    Row(
        modifier = Modifier.fillMaxSize()
            .pointerInput(state) {
                detectTapGestures(
                    onTap = { offset ->
                        handler.layout.onChangeLayout()
                    }
                )
            }
    ) {
        Box(Modifier.weight(1F)) {
            Notebook(state.notebook, handler.notebook)

            if (state.layout is FullLayoutState) {
                Summary(
                    state = state.notebook,
                    modifier = Modifier.align(Alignment.TopStart)
                        .offset(x = 16.dp, y = 16.dp)
                )

                ToolBar(
                    state = state.notebook,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-16).dp)
                )
            }
        }

        if (state.layout !is WyswygLayoutState) {
            Spacer(Modifier.width(8.dp))
            PropertyEditor()
        }
    }
}
