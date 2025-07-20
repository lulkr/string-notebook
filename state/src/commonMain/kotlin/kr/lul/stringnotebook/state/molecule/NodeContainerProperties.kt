package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

/**
 * 노드 컨테이너의 속성을 정의하는 클래스입니다.
 *
 * @property border 테두리 상태
 * @property background 배경 상태
 * @property padding 내부 여백
 * @property node 노드 속성
 */
@Immutable
data class NodeContainerProperties(
    val border: BorderState,
    val background: BackgroundState,
    val padding: Dp,
    val node: NodeProperties
) {
    @ExperimentalStdlibApi
    val summary = "(b=${border.summary}, bg=${background.summary}, p=$padding, n=${node.summary})"
}
