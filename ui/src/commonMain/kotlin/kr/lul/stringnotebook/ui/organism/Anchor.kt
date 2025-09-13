package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.organism.AnchorState
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Anchor(anchor: AnchorState, hovered: Boolean = false) {
    logger.v("#Anchor args : anchor=$anchor, hovered=$hovered")

    val background: Color
    when {
        hovered -> {
            background = AnchorDefaults.hovered()
        }

        else -> {
            background = MaterialTheme.colorScheme.tertiaryContainer
        }
    }
    Box(Modifier.size(AnchorDefaults.RADIUS).background(background, CircleShape))
}