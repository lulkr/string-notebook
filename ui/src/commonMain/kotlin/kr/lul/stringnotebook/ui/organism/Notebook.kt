package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
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
    Layout(
        content = {
            Text("$state")
        },
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .pointerInput(state) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        handler.onDoubleClick(offset)
                    },
                    onLongPress = { offset ->
                        handler.onLongClick(offset)
                    },
                    onTap = { offset ->
                        handler.onClick(offset)
                    }
                )
            }
    ) { measurables, constraints ->
        logger.d("#Notebook.Layout.measurePolicy args : measurables=$measurables,  constraints=$constraints")
        val childConstraints = constraints.copy(minWidth = 0, minHeight = 0)
        val placeables = measurables.map { measurable ->
            measurable.measure(childConstraints)
        }
        logger.d(
            "#Notebook.Layout.measurePolicy measured : placeables=${
                placeables.map { placeable ->
                    "(${placeable.width}x${placeable.height})"
                }
            }"
        )

        val x = (constraints.maxWidth - placeables[0].width) / 2
        val y = (constraints.maxHeight - placeables[0].height) / 2

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables[0].place(x = x, y = y)
        }
    }

    state.menu?.let { menu ->
        ContextMenu(menu)
    }
}