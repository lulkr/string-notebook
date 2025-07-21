package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable

/**
 * 노트북 상의 영역.
 *
 * @property startX 영역의 시작 X 좌표.
 * @property startY 영역의 시작 Y 좌표.
 * @property endX 영역의 끝 X 좌표.
 * @property endY 영역의 끝 Y 좌표.
 */
@Immutable
data class Area(
    val startX: Float,
    val startY: Float,
    val endX: Float,
    val endY: Float
) {
    fun contains(x: Float, y: Float) = x in startX..endX &&
            y in startY..endY
}
