package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Density

val Offset.summary: String
    get() = "($x, $y)"

/**
 * Pixel 단위 오프셋을 DP 단위 오프셋으로 변환.
 */
fun Offset.toDp(density: Density) = copy(
    x = with(density) { x.toDp().value },
    y = with(density) { y.toDp().value }
)

/**
 * @param diff 차이.
 */
operator fun Offset.minus(diff: Size) = copy(x = x - diff.width, y = y - diff.height)

/**
 * @param diff 차이.
 */
operator fun Offset.plus(diff: Size) = copy(x = x + diff.width, y = y + diff.height)