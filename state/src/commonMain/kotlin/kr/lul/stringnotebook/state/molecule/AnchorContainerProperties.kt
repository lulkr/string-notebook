package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 앵커 컨테이너의 속성을 정의하는 데이터 클래스.
 *
 * @property border 테두리.
 * @property background 배경.
 * @property padding 여백 크기.
 * @property anchor 앵커 속성.
 */
@Immutable
data class AnchorContainerProperties(
    val border: BorderState,
    val background: BackgroundState,
    val padding: Dp,
    val anchor: AnchorProperties
) {
    constructor(border: BorderState, backgroundState: BackgroundState, padding: Int, anchor: AnchorProperties) : this(
        border = border,
        background = backgroundState,
        padding = padding.dp,
        anchor = anchor
    )
}
