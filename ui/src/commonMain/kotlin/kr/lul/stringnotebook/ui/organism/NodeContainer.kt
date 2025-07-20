package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.NodeContainerProperties
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
import kr.lul.stringnotebook.state.organism.ObjectPreviewContext
import kr.lul.stringnotebook.ui.molecule.NodeContainerPropertiesDefaults
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun NodeContainer(
    node: NodeState,
    context: Context,
    processor: EventProcessor = EventProcessor.NoOp,
    properties: NodeContainerProperties? = null
) {
    logger.v("#NodeContainer args : node=$node, context=$context, processor=$processor, properties=$properties)")

    val focused = (context is ObjectFocusedContext && context.obj == node) ||
            (context is ObjectPreviewContext && context.target == node)
    val interactionSource = remember { MutableInteractionSource() }
    val internalProperties = when {
        properties != null -> properties
        focused -> NodeContainerPropertiesDefaults.focused()
        else -> NodeContainerPropertiesDefaults.default()
    }
    logger.v("#NodeContainer : internalProperties=$internalProperties")

    Box(
        modifier = Modifier.hoverable(interactionSource)
            .pointerInput(node) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        logger.d("#NodeContainer.onDoubleTap : node=$node, offset=$offset")
                    },
                    onTap = { offset ->
                        logger.d("#NodeContainer.onTap : node=$node, offset=$offset")
                    }
                )
            }
            .pointerInput(node, focused) {
                detectDragGestures(
                    onDragStart = { offset ->
                        logger.d("#NodeContainer.onDragStart : node=$node, offset=$offset")
                    },
                    onDragEnd = {
                        logger.d("#NodeContainer.onDragEnd : node=$node")
                    },
                    onDrag = { change, dragAmount ->
                        logger.d("#NodeContainer.onDrag : change=$change, dragAmount=$dragAmount")
                    }
                )
            }
            .border(internalProperties.border.width, internalProperties.border.brush, internalProperties.border.shape)
            .background(
                internalProperties.background.brush,
                internalProperties.background.shape,
                internalProperties.background.alpha
            )
            .padding(internalProperties.padding)
    ) {
        Node(node, context, processor, internalProperties.node)
    }
}