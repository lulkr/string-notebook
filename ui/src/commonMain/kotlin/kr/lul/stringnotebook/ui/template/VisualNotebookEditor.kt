package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.organism.Anchor
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun VisualNotebookEditor(state: NotebookState, modifier: Modifier = Modifier) {
    logger.v("#VisualNotebookEditor args : state=$state, modifier=$modifier")

    Box(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        Layout(
            content = {
                for (anchor in state.anchors) {
                    Anchor(anchor)
                }
            }
        ) { measurables, constraints ->
            val placeables = measurables.mapIndexed { index, measurable ->
                measurable.measure(constraints)
            }
            logger.v("#VisualNotebookEditor layout : constraints=$constraints, placeables=$placeables")

            layout(constraints.maxWidth, constraints.maxHeight) {
                placeables.forEachIndexed { index, placeable ->
                    val anchor = state.anchors[index]
                    placeable.place(anchor.x, anchor.y)
                }
            }
        }
    }
}