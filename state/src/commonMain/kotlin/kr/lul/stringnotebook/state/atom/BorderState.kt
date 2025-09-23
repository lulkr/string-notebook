package kr.lul.stringnotebook.state.atom

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp

/**
 * 외곽선 정보.
 *
 * @property width 외곽선의 두께.
 * @property brush 외곽선의 브러시.
 * @property shape 외곽선의 모양.
 */
@Immutable
data class BorderState(
    val width: Dp,
    val brush: Brush = SolidColor(Color.Unspecified),
    val shape: Shape = RectangleShape
) {
    @ExperimentalStdlibApi
    val summary = "($width, ${brush.summary}, ${shape.summary})"

    constructor(
        width: Dp,
        color: Color = Color.Unspecified,
        shape: Shape = RectangleShape
    ) : this(width, SolidColor(color), shape)

    fun copy(
        color: Color,
        width: Dp = this.width,
        shape: Shape = this.shape
    ) = BorderState(width, SolidColor(color), shape)
}
