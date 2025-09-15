package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Anchor(anchor: AnchorState, hovered: Boolean = false) {
    logger.v("#Anchor args : anchor=$anchor, hovered=$hovered")

    val editContext = LocalEditContext.current
    logger.v("#Anchor : editContext=$editContext")

    val properties: AnchorProperties = when {
        hovered -> editContext.anchorPropertiesHovered
            ?: AnchorPropertiesDefaults.hovered()

        else -> editContext.anchorPropertiesDefault
            ?: AnchorPropertiesDefaults.default()
    }
    logger.v("#Anchor : properties=$properties")

    Box(
        Modifier.size(properties.radius.times(2))
            .background(properties.color, CircleShape)
    )
}