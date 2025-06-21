package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputChange
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

    /*
     * 드래그 중에 사용되는 오프셋. 드래그 시작 시점의 오프셋을 저장하고, 드래그 중에는 그 오프셋에 드래그된 양을 더해줌.
     * 드래그가 끝나면 최종 위치를 계산하여 MoveEvent를 발생시킴.
     */
    var moveAmount by remember(state.id) {
        mutableStateOf(Offset.Zero)
    }

    Box(
        modifier = Modifier
            .size(preferences.size.dp)
            .clickable(!context.lock && context.active != state) {
                processor(ActivateEvent(target = state.id))
            }
            .pointerInput(state.id, context.version) {
                detectDragGestures(
                    onDragEnd = {
                        logger.d("#Anchor.onDragEnd called : moveAmount=$moveAmount")

                        if (!context.lock && context.active == state) {
                            processor(
                                MoveEvent(
                                    target = context.active!!.id,
                                    x = state.x + moveAmount.x.toDp().value,
                                    y = state.y + moveAmount.y.toDp().value
                                )
                            )
                            moveAmount = Offset.Zero
                        }
                    },
                    onDrag = fun(change: PointerInputChange, dragAmount: Offset) {
                        logger.v("#Anchor.onDrag args : change=$change, dragAmount=$dragAmount")

                        if (!context.lock && context.active == state) {
                            change.consume()
                            moveAmount = change.position
                        }
                    }
                )
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