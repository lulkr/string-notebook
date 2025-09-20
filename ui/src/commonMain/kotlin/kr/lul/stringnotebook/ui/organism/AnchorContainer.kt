package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.atom.background
import kr.lul.stringnotebook.ui.atom.border
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun BoxScope.AnchorContainer(
    anchor: AnchorState,
    zIndex: Float = Z_INDEX_ANCHOR_BASE
) {
    logger.v("#AnchorContainer args : anchor=$anchor, zIndex=$zIndex")

    val editContext = LocalEditContext.current
    logger.v("#AnchorContainer : editContext=$editContext")

    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    logger.v("#AnchorContainer : interactionSource=$interactionSource, hovered=$hovered")

    val properties: AnchorProperties = when {
        hovered -> editContext.anchorPropertiesHovered
            ?: AnchorPropertiesDefaults.hovered()

        else -> editContext.anchorPropertiesDefault
            ?: AnchorPropertiesDefaults.default()
    }
    logger.v("#AnchorContainer : properties=$properties")

    AnchorContainer(anchor, zIndex, interactionSource, properties)
}

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
internal fun BoxScope.AnchorContainer(
    anchor: AnchorState,
    zIndex: Float = Z_INDEX_ANCHOR_BASE,
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    properties: AnchorProperties = AnchorProperties.Default
) {
    Box(
        Modifier.offset(anchor.position.x.dp, anchor.position.y.dp)
            .zIndex(zIndex)
            .hoverable(interactionSource)
            .border(properties.containerBorder)
            .background(properties.containerBackground)
            .padding(properties.containerPadding)
    ) {
        Anchor(anchor, properties.radius, properties.color)
    }
}