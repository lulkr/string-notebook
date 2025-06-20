package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
fun Viewer(objects: List<ObjectState>, context: NotebookContext, processor: EventProcessor) {
    logger.v("#Viewer args : targets=$objects, context=$context, processor=$processor")

    Layout(
        content = {
            for (obj in objects) {
                when (obj) {
                    is AnchorState -> Anchor(obj, context, processor)
                }
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.mapIndexed { index, measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEachIndexed { index, placeable ->
                when (val target = objects[index]) {
                    is AnchorState -> placeable.place(
                        x = Dp(target.x).roundToPx(),
                        y = Dp(target.y).roundToPx(),
                        zIndex = target.z
                    )
                }
            }
        }
    }
}