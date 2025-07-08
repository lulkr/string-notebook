package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.event.OpenEditorEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.NodeColors
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.ObjectActivatedContext
import kr.lul.stringnotebook.state.organism.ObjectEditContext
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
    context: Context = NeutralContext(),
    processor: EventProcessor = EventProcessor.NoOp
) {
    logger.v("#Node args : state=$state, context=$context, processor=$processor")

    val activated = remember(state, context) {
        (context is ObjectActivatedContext && context.active == state) ||
                (context is ObjectEditContext && context.active == state)
    }

    if (activated && context is ObjectEditContext) {
        NodeEditor(state, context, processor)
    } else {
        NodeViewer(state, context, processor, activated)
    }
}

@Composable
@ExperimentalUuidApi
fun NodeEditor(
    state: NodeState,
    context: ObjectEditContext,
    processor: EventProcessor,
    colors: NodeColors = NodeDefaults.colors()
) {
    logger.v("#NodeEditor args : state=$state, context=$context, processor=$processor, colors=$colors")

    val focusRequester = remember(state.id) {
        FocusRequester()
    }
    LaunchedEffect(state.id) {
        focusRequester.requestFocus()
    }

    OutlinedTextField(
        value = state.text,
        onValueChange = {
            logger.d("#Node.onValueChange called : text=$it")
            processor(UpdateNodeTextEvent(state.id, it))
        },
        modifier = Modifier
            .focusRequester(focusRequester)
            .pointerInput(state, context) {
                detectTapGestures(
                    onTap = { offset ->
                        processor(ActivateEvent(state.id))
                    }
                )

                detectDragGestures { change, dragAmount ->
                    logger.d("#Node.onDrag called : change=$change, dragAmount=$dragAmount")

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
            .background(colors.background)
            .padding(16.dp),
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

@Composable
@ExperimentalUuidApi
fun NodeViewer(
    state: NodeState,
    context: Context = NeutralContext(),
    processor: EventProcessor = EventProcessor.NoOp,
    activated: Boolean = false,
    colors: NodeColors = NodeDefaults.colors()
) {
    logger.v("#NodeViewer args : state=$state, context=$context, processor=$processor, activated=$activated, colors=$colors")

    Text(
        text = state.text,
        modifier = Modifier
            .pointerInput(state, context) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        processor(OpenEditorEvent(state.id))
                    },
                    onTap = { offset ->
                        if (!activated) {
                            processor(ActivateEvent(state.id))
                        }
                    }
                )

                detectDragGestures { change, dragAmount ->
                    if (activated) {
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
            .background(if (activated) colors.background else colors.inactiveBackground)
            .padding(16.dp)
    )
}