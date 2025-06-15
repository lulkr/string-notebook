package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
fun Viewer(targets: List<ObjectState>, context: NotebookContext, processor: EventProcessor) {
    logger.v("#Viewer args : targets=$targets, context=$context, processor=$processor")

    Layout(
        content = {
            for (obj in targets) {
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
                when (val target = targets[index]) {
                    is AnchorState -> placeable.place(target.x.toInt(), target.y.toInt(), target.z)
                }
            }
        }
    }
}