package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.NotebookHandler
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.template.ContextMenu
import kr.lul.stringnotebook.ui.template.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 편집기.
 */
@Composable
@ExperimentalUuidApi
fun Notebook(
    state: NotebookState,
    handler: NotebookHandler = NotebookHandler.NoOp
) {
    var contextMenuPosition by remember {
        mutableStateOf<Offset?>(null)
    }

    Box(
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(state) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        contextMenuPosition = offset
                    },
                    onLongPress = { offset ->
                        contextMenuPosition = offset
                    },
                    onTap = { offset ->
                        handler.onClickBackground()
                    }
                )
            },
        Alignment.Center
    ) {
        Column(
            modifier = Modifier.pointerInput(state) {
                detectTapGestures(
                    onTap = { offset ->
                        logger.d("#Notebook.Text.onTap 노트북 클릭 대상에서 제외.")
                    }
                )
            }
        ) {
            Text("${state.id}", Modifier.padding(8.dp))
            Text(state.name, Modifier.padding(8.dp))
            state.description?.let { description ->
                Text(description, Modifier.padding(8.dp))
            }
        }
    }

    contextMenuPosition?.let { offset ->
        ContextMenu(
            position = offset,
            onDismissRequest = { contextMenuPosition = null }
        )
    }
}