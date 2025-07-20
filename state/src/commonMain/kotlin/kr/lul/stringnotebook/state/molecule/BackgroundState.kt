package kr.lul.stringnotebook.state.molecule

import androidx.annotation.FloatRange
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import kr.lul.stringnotebook.state.atom.summary

/**
 * 배경 상태를 나타내는 데이터 클래스입니다.
 *
 * @property brush 배경에 사용되는 브러시.
 * @property shape 배경의 모양.
 * @property alpha 배경의 투명도 (`0.0F` ~ `1.0F`). `1.0`은 불투명.
 */
@Immutable
data class BackgroundState(
    val brush: Brush = SolidColor(Color.Transparent),
    val shape: Shape = RectangleShape,
    @FloatRange(from = 0.0, to = 1.0) val alpha: Float = 1.0F
) {
    @ExperimentalStdlibApi
    val summary = "(b=${brush.summary}, s=${shape.summary}, a=$alpha)"

    constructor(
        color: Color,
        shape: Shape = RectangleShape,
        @FloatRange(from = 0.0, to = 1.0) alpha: Float = 1.0F
    ) : this(SolidColor(color), shape, alpha)

    fun copy(
        color: Color,
        shape: Shape = this.shape,
        @FloatRange(from = 0.0, to = 1.0) alpha: Float = this.alpha
    ) = BackgroundState(SolidColor(color), shape, alpha)
}
