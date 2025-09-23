package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import kotlin.math.max

/**
 * `@Preview` 등에서 이미지 리소스를 로딩할 수 없을 때 사용할 플레이스홀더 페인터.
 */
class PlaceholderPainter(
    private val foreground: Color,
    private val background: Color
) : Painter() {
    override val intrinsicSize = Size.Unspecified

    override fun DrawScope.onDraw() {
        // 배경
        drawRect(color = background)

        // 테두리
        val stroke = max(1f, 1.dp.toPx())
        drawRect(color = foreground, style = Stroke(width = stroke))

        // 대각선 X
        drawLine(
            color = foreground,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = stroke
        )
        drawLine(
            color = foreground,
            start = Offset(size.width, 0f),
            end = Offset(0f, size.height),
            strokeWidth = stroke
        )
    }
}