package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun Notebook(state: NotebookState, modifier: Modifier = Modifier) {
    logger.v("#Notebook args : state=$state")
    Layout(
        content = {
            for (anchor in state.anchors) {
                Anchor(state = anchor)
            }
        },
        modifier = modifier
    ) { measurables, constraints ->
        val placeables = measurables.mapIndexed { index, measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEachIndexed { index, placeable ->
                val anchor = state.anchors[index]
                placeable.place(anchor.x, anchor.y)
            }
        }
    }
}