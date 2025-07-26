package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.LinkState
import kotlin.math.abs
import kotlin.math.min
import kotlin.uuid.ExperimentalUuidApi

/**
 * 두 오브젝트 사이의 링크를 표시하는 UI.
 */
@ExperimentalUuidApi
@Composable
fun Link(link: LinkState, context: Context, processor: EventProcessor) {
    logger.v("#Link args : link=$link, context=$context, processor=$processor")

    val x = min(link.from.x, link.to.x)
    val y = min(link.from.y, link.to.y)
    val width = abs(link.to.x - link.from.x)
    val height = abs(link.to.y - link.from.y)
    logger.v("#Link : x=$x, y=$y, width=$width, height=$height")

    Box(
        modifier = Modifier.size(width.dp, height.dp)
            .drawWithCache {
                val path = Path()
                path.moveTo((link.from.x - x).dp.toPx(), (link.from.y - y).dp.toPx())
                path.lineTo((link.to.x - x).dp.toPx(), (link.to.y - y).dp.toPx())

                onDrawBehind {
                    drawPath(path, Color.Blue, style = Stroke(1.0F))
                }
            },
        content = { /* No content needed for link */ }
    )
}