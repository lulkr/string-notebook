package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kr.lul.stringnotebook.state.atom.toDp
import kr.lul.stringnotebook.state.organism.NotebookHandler
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.template.ContextMenu
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 편집기.
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Notebook(
    state: NotebookState,
    handler: NotebookHandler = NotebookHandler.NoOp
) {
    logger.v("#Notebook args : state=${state.summary}, handler=$handler")

    val density = LocalDensity.current

    Box(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(state) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        handler.onDoubleClick(offset.toDp(density))
                    },
                    onLongPress = { offset ->
                        handler.onLongClick(offset.toDp(density))
                    },
                    onTap = { offset ->
                        handler.onClick(offset.toDp(density))
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        state.menu?.let { menu ->
            Box(
                modifier = Modifier
                    .zIndex(Float.MAX_VALUE)
                    .align(Alignment.TopStart)
                    .offset(menu.position.x.dp, menu.position.y.dp)
            ) {
                ContextMenu(
                    state = menu,
                    onDismissRequest = { handler.onClick(Offset.Unspecified) }
                )
            }
        }

        if (state.notes.isEmpty()) {
            Text(state.summary)
        }
    }
}