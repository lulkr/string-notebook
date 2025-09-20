package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.state.organism.AnchorState
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Anchor(anchor: AnchorState, radius: Dp, color: Color) {
    logger.v("#Anchor args : anchor=$anchor, radius=$radius, color=$color")

    Box(
        Modifier.size(radius.times(2))
            .background(color, CircleShape)
    )
}