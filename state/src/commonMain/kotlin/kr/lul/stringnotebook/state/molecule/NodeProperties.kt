package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * 노드 내용의 속성.
 *
 * @property width 폭.
 * @property height 높이.
 * @property background 배경 브러시.
 * @property border 테두리 상태.
 * @property padding 여백.
 */
@Immutable
data class NodeProperties(
    val width: Dp,
    val height: Dp,
    val background: BackgroundState,
    val border: BorderState,
    val padding: Dp,
) {
    val summary: String
        get() = "($width, $height)"
}
