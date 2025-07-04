package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.ui.molecule.NodeDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * @see kr.lul.stringnotebook.preview.ui.organism.NodePreview
 */
@Composable
@ExperimentalUuidApi
fun Node(
    state: NodeState,
    context: NotebookContext = NotebookContext.NoOp,
    processor: EventProcessor = EventProcessor.NoOp
) {
    logger.v("#Node args : state=$state, context=$context, processor=$processor")

    val colors = NodeDefaults.colors()

    if (state != context.active) {
        LocalFocusManager.current
            .clearFocus()
    }

    OutlinedTextField(
        value = state.text,
        onValueChange = {
            if (!context.lock && context.active == state) {
                logger.d("#Node.onValueChange called : text=$it")
                processor(UpdateNodeTextEvent(state.id, it))
            }
        },
        modifier = Modifier
            .clickable(!context.lock && state != context.active) {
                logger.d("#Node.onClick args : state=$state, context=$context")
                processor(ActivateEvent(state.id))
            }
            .pointerInput(state, context) {
                detectDragGestures { change, dragAmount ->
                    logger.d("#Node.onDrag called : change=$change, dragAmount=$dragAmount")

                    if (!context.lock && context.active == state) {
                        change.consume()
                        processor(
                            MoveEvent(
                                target = context.active!!.id,
                                x = state.x + dragAmount.x.toDp().value,
                                y = state.y + dragAmount.y.toDp().value
                            )
                        )
                    }
                }
            }
            .onFocusChanged { focus ->
                if (!context.lock) {
                    when {
                        focus.isFocused && state != context.active -> {
                            logger.d("#Node.onFocusChanged : focus=$focus")
                            processor(ActivateEvent(state.id))
                        }
                    }
                }
            }
            .background(if (state == context.active) colors.background else colors.inactiveBackground)
            .padding(16.dp),
        readOnly = state != context.active,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colors.text,
            unfocusedTextColor = colors.inactiveText,
            focusedContainerColor = colors.inactiveText,
            unfocusedContainerColor = colors.inactiveBackground,
            focusedBorderColor = colors.border,
            unfocusedBorderColor = colors.inactiveBorder
        )
    )
}