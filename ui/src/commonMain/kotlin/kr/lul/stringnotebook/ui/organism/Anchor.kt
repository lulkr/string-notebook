package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.ui.molecule.AnchorDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * @see kr.lul.stringnotebook.preview.ui.organism.AnchorPreview
 */
@Composable
@ExperimentalUuidApi
fun Anchor(
    state: AnchorState,
    context: NotebookContext = NotebookContext.NoOp,
    processor: EventProcessor = EventProcessor.NoOp
) {
    logger.v("#Anchor args : state=$state, context=$context, processor=$processor")

    val preferences = context.preferences.anchor
    val colors = AnchorDefaults.colors()

    Box(
        modifier = Modifier
            .size(preferences.size.dp)
            .clickable(!context.lock && context.active != state) {
                processor(ActivateEvent(target = state.id))
            }
            .pointerInput(state, context) {
                detectDragGestures { change, dragAmount ->
                    logger.v("#Anchor.onDrag args : change=$change, dragAmount=$dragAmount")

                    if (!context.lock && context.active == state) {
                        change.consume()
                        processor(
                            MoveEvent(
                                target = state.id,
                                x = state.x + dragAmount.x.toDp().value,
                                y = state.y + dragAmount.y.toDp().value
                            )
                        )
                    }
                }
            }
            .border(
                1.dp, if (state == context.active) {
                    colors.activeBorder
                } else {
                    colors.inactiveBorder
                }, RoundedCornerShape(50)
            )
            .background(
                if (state == context.active) {
                    colors.active
                } else {
                    colors.inactive
                }, RoundedCornerShape(50)
            )
    )
}