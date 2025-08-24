package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.Density

/**
 * Pixel 단위 오프셋을 DP 단위 오프셋으로 변환.
 */
fun Offset.toDp(density: Density) = copy(
    x = with(density) { x.toDp().value },
    y = with(density) { y.toDp().value }
)