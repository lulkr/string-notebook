package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.molecule.NodeColors

/**
 * [kr.lul.stringnotebook.ui.organism.Node]의 기본 정보를 제공한다.
 */
object NodeDefaults {
    /**
     * 기본 [NodeColors]를 생성한다.
     *
     * @param background 선택한 노드의 배경색
     * @param border 선택한 테두리 색
     * @param text 선택한 노드의 텍스트 색
     * @param inactiveBackground 비활성화된 노드의 배경색
     * @param inactiveBorder 비활성화된 노드의 테두리 색
     * @param inactiveText 비활성화된 노드의 텍스트 색
     */
    @Composable
    fun colors(
        background: Color = MaterialTheme.colorScheme.primaryContainer,
        border: Color = MaterialTheme.colorScheme.primary,
        text: Color = MaterialTheme.colorScheme.onPrimaryContainer,
        inactiveBackground: Color = MaterialTheme.colorScheme.surfaceContainer,
        inactiveBorder: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        inactiveText: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    ) = NodeColors(
        background,
        border,
        text,
        inactiveBackground,
        inactiveBorder,
        inactiveText
    )
}