package kr.lul.stringnotebook.state.molecule

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.state.atom.summary

/**
 * 앵커를 그리기 위한 속성을 정의하는 데이터 클래스.
 *
 * @property radius 앵커의 반지름.
 * @property fill 앵커의 채우기 브러시.
 */
data class AnchorProperties(
    val radius: Dp,
    val fill: Brush
) {
    @ExperimentalStdlibApi
    val summary = "(r=$radius, f=${fill.summary})"

    /**
     * @param radius 반지름
     * @param fill 채우기 색상
     */
    constructor(radius: Dp, fill: Color) : this(radius, SolidColor(fill))
}
