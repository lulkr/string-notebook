package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.LinkState
import kotlin.math.abs
import kotlin.uuid.ExperimentalUuidApi

/**
 * 두 오브젝트 사이의 링크를 표시하는 UI.
 */
@ExperimentalUuidApi
@Composable
fun Link(link: LinkState, context: Context, processor: EventProcessor) {
    logger.v("#Link args : link=$link, context=$context, processor=$processor")

    val width = Dp(abs(link.to.x - link.from.x))
    val height = Dp(abs(link.to.y - link.from.y))
    logger.v("#Link size : width=$width, height=$height")

    Box(
        modifier = Modifier.size(width, height)
            .background(Color.Green)
    ) {

    }
}