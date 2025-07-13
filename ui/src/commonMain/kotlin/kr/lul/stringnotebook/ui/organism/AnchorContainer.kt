package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kr.lul.stringnotebook.domain.event.FocusObjectEvent
import kr.lul.stringnotebook.domain.event.MovePreviewEvent
import kr.lul.stringnotebook.domain.event.StartMoveObjectEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.AnchorContainerProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
import kr.lul.stringnotebook.state.organism.ObjectPreviewContext
import kr.lul.stringnotebook.ui.molecule.AnchorContainerPropertiesDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * 화면상의 표시와 조작을 편하게 할 수 있도록 더 크고 알아보기 쉽게 만든 앵커 컨테이너.
 */
@Composable
@ExperimentalUuidApi
fun AnchorContainer(
    anchor: AnchorState,
    context: Context,
    processor: EventProcessor = EventProcessor.NoOp,
    properties: AnchorContainerProperties? = null
) {
    logger.v("#AnchorContainer args : anchor=$anchor, context=$context, processor=$processor")

    val focused = (context is ObjectFocusedContext && context.obj == anchor) ||
            (context is ObjectPreviewContext && context.target == anchor)
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val internalProperties = when {
        null != properties -> properties
        focused -> AnchorContainerPropertiesDefaults.focused()
        hovered -> AnchorContainerPropertiesDefaults.hover()
        else -> AnchorContainerPropertiesDefaults.default()
    }
    logger.v(
        listOf(
            "focused=$focused",
            "hovered=$hovered",
            "properties=$internalProperties"
        ).joinToString(", ", "#AnchorContainer : ")
    )

    Box(
        modifier = Modifier
            .hoverable(interactionSource)
            .pointerInput(anchor) {
                detectTapGestures(
                    onDoubleTap = { offset ->
                        logger.d("#AnchorContainer.onDoubleTap args : offset=$offset.")
                    },
                    onTap = { offset ->
                        logger.d("#AnchorContainer.onTap args : offset=$offset.")

                        if (!focused) {
                            processor(FocusObjectEvent(anchor.id))
                        }
                    }
                )
            }
            .pointerInput(anchor, focused) {
                detectDragGestures(
                    onDragStart = { offset ->
                        logger.d("#AnchorContainer.onDragStart args : offset=$offset.")

                        if (focused) {
                            processor(StartMoveObjectEvent(anchor.id))
                        }
                    },
                    onDragEnd = {
                        logger.d("#AnchorContainer.onDragEnd called.")
                    },
                    onDrag = { change, dragAmount ->
                        logger.v("#AnchorContainer.onDrag args : change=$change, dragAmount=$dragAmount.")

                        if (focused && context is ObjectPreviewContext && null != anchor.preview) {
                            change.consume()
                            anchor.preview!!.let {
                                processor(
                                    MovePreviewEvent(
                                        anchor.id,
                                        it.x + dragAmount.x.toDp().value,
                                        it.y + dragAmount.y.toDp().value
                                    )
                                )
                            }
                        }
                    }
                )
            }
            .border(
                internalProperties.border.width,
                internalProperties.border.brush,
                internalProperties.border.shape
            )
            .background(
                internalProperties.background.brush,
                internalProperties.background.shape,
                internalProperties.background.alpha
            )
            .padding(internalProperties.padding),
        contentAlignment = Alignment.Center
    ) {
        Anchor(anchor, context, processor, internalProperties.anchor)
    }
}
