package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * [kr.lul.stringnotebook.ui.organism.Node]의 색상 정보를 담는 데이터 클래스입니다.
 *
 * @property background 선택한 노드의 배경색
 * @property border 선택한 테두리 색
 * @property text 선택한 노드의 텍스트 색
 * @property inactiveBackground 비활성화된 노드의 배경색
 * @property inactiveBorder 비활성화된 노드의 테두리 색
 * @property inactiveText 비활성화된 노드의 텍스트 색
 */
@Immutable
data class NodeColors(
    val background: Color = Color.Unspecified,
    val border: Color = Color.Unspecified,
    val text: Color = Color.Unspecified,
    val inactiveBackground: Color = Color.Unspecified,
    val inactiveBorder: Color = Color.Unspecified,
    val inactiveText: Color = Color.Unspecified
)