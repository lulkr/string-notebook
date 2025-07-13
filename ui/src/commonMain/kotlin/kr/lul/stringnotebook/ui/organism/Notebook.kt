package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.state.organism.PreviewAnchorState
import kr.lul.stringnotebook.ui.molecule.AnchorContainerPropertiesDefaults
import kr.lul.stringnotebook.ui.molecule.AnchorPropertiesDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun NoteBookContent(objects: List<ObjectState>, context: Context, processor: EventProcessor) {
    logger.v("#NoteBookContent args : objects=$objects, context=$context, processor=$processor")

    Layout(
        content = {
            for (obj in objects) {
                when (obj) {
                    is AnchorState -> AnchorContainer(obj, context, processor)
                    is PreviewAnchorState -> Preview(obj)
                    is NodeState -> Node(obj, context, processor)
                }
            }
        }
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEachIndexed { index, placeable ->
                when (val obj = objects[index]) {
                    is AnchorState -> placeable.place(
                        x = (Dp(obj.x) - AnchorContainerPropertiesDefaults.PADDING - AnchorPropertiesDefaults.RADIUS).roundToPx(),
                        y = (Dp(obj.y) - AnchorContainerPropertiesDefaults.PADDING - AnchorPropertiesDefaults.RADIUS).roundToPx(),
                        zIndex = obj.z
                    )

                    is NodeState -> placeable.place(
                        x = Dp(obj.x).roundToPx(),
                        y = Dp(obj.y).roundToPx(),
                        zIndex = obj.z
                    )

                    is PreviewAnchorState -> {
                        placeable.place(
                            x = (Dp(obj.x) - AnchorPropertiesDefaults.RADIUS).roundToPx(),
                            y = (Dp(obj.y) - AnchorPropertiesDefaults.RADIUS).roundToPx(),
                            zIndex = Float.MAX_VALUE
                        )
                    }
                }
            }
        }
    }
}