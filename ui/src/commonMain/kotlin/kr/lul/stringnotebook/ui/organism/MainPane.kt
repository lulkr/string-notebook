package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 에디터.
 *
 * @see kr.lul.stringnotebook.preview.ui.organism.MainPanePreview
 */
@Composable
@ExperimentalUuidApi
fun MainPane(state: NotebookState, context: NotebookContext, processor: EventProcessor, modifier: Modifier = Modifier) {
    logger.v("#MainPane args : state=$state, context=$context, processor=$processor, modifier=$modifier")

    val targets = state.objects // TODO 뷰포트로 걸러내기.

    Layout(
        modifier = modifier,
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