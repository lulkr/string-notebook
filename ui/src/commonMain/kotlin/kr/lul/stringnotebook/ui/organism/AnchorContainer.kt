package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.organism.AnchorContainerState
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.atom.background
import kr.lul.stringnotebook.ui.atom.border
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun BoxScope.AnchorContainer(
    state: AnchorContainerState,
    anchor: AnchorState,
    zIndex: Float = Z_INDEX_ANCHOR_BASE
) {
    logger.v("#AnchorContainer args : state=$state, anchor=$anchor, zIndex=$zIndex")

    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    logger.v("#AnchorContainer : hovered=$hovered")

    val border: BorderState
    val padding: PaddingValues
    val background: BackgroundState
    when {
        hovered -> AnchorContainerDefaults.hovered().let { default ->
            border = default.border
            padding = default.padding
            background = default.background
        }

        else -> {
            border = state.border
            padding = state.padding
            background = state.background
        }
    }
    logger.v("#AnchorContainer : border=$border, padding=$padding, background=$background")

    Box(
        Modifier.offset(anchor.position.x.dp, anchor.position.y.dp)
            .zIndex(zIndex)
            .hoverable(interactionSource)
            .border(border)
            .background(background)
            .padding(padding)
    ) {
        Anchor(anchor, hovered)
    }
}