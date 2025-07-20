package kr.lul.stringnotebook.ui.molecule

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.BackgroundState
import kr.lul.stringnotebook.state.molecule.BorderState
import kr.lul.stringnotebook.state.molecule.NodeContainerProperties
import kr.lul.stringnotebook.state.molecule.NodeProperties

/**
 * [NodeContainerProperties]의 기본값을 제공하는 객체입니다.
 */
object NodeContainerPropertiesDefaults {
    /**
     * 테두리의 기본값.
     */
    /**
     * 패딩의 기본 속성.
     */
    val PADDING = 8.dp

    /**
     * 테두리의 기본값.
     */
    val BORDER = BorderState(1.dp, Color.Transparent, RoundedCornerShape(PADDING))

    /**
     * 배경의 기본값.
     */
    val BACKGROUND = BackgroundState(Color.Transparent, RoundedCornerShape(PADDING))

    /**
     * 선택한 노드 컨테이너의 속성을 반환한다.
     */
    @Composable
    fun focused(
        border: BorderState = BORDER.copy(brush = SolidColor(MaterialTheme.colorScheme.outline)),
        background: BackgroundState = BACKGROUND,
        padding: Dp = PADDING,
        node: NodeProperties = NodePropertiesDefaults.focused()
    ): NodeContainerProperties = NodeContainerProperties(border, background, padding, node)

    /**
     * 노드 컨테이너의 기본 속성을 반환한다.
     */
    @Composable
    fun default(
        border: BorderState = BORDER,
        background: BackgroundState = BACKGROUND,
        padding: Dp = PADDING,
        node: NodeProperties = NodePropertiesDefaults.default()
    ): NodeContainerProperties = NodeContainerProperties(border, background, padding, node)
}