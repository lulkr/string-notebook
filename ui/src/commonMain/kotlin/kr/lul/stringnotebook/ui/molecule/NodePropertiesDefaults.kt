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
import kr.lul.stringnotebook.state.molecule.NodeProperties

/**
 * 노드 내용의 기본 속성.
 */
object NodePropertiesDefaults {
    /**
     * 노드의 기본 폭.
     */
    val WIDTH = 150.dp

    /**
     * 노드의 기본 높이.
     */
    val HEIGHT = 40.dp

    /**
     * 노드의 기본 여백.
     */
    val PADDING = 8.dp

    /**
     * 노드의 기본 배경 브러시.
     */
    val BACKGROUND = BackgroundState(SolidColor(Color.Transparent), RoundedCornerShape(PADDING))

    /**
     * 노드의 기본 테두리 상태.
     */
    val BORDER = BorderState(1.dp, Color.Transparent, RoundedCornerShape(PADDING))

    /**
     * 노드의 기본 속성.
     */
    @Composable
    fun default(
        width: Dp = WIDTH,
        height: Dp = HEIGHT,
        background: BackgroundState = BACKGROUND.copy(color = MaterialTheme.colorScheme.surfaceContainer),
        border: BorderState = BORDER,
        padding: Dp = PADDING
    ): NodeProperties = NodeProperties(
        width = width,
        height = height,
        background = background,
        border = border,
        padding = padding
    )

    /**
     * 포커스한 노드의 속성.
     */
    @Composable
    fun editing(
        width: Dp = WIDTH,
        height: Dp = HEIGHT,
        background: BackgroundState = BACKGROUND.copy(MaterialTheme.colorScheme.primaryContainer),
        border: BorderState = BORDER.copy(color = MaterialTheme.colorScheme.outline),
        padding: Dp = PADDING
    ): NodeProperties = NodeProperties(
        width = width,
        height = height,
        background = background,
        border = border,
        padding = padding
    )

    /**
     * 포커스한 노드의 속성.
     */
    @Composable
    fun focused(
        width: Dp = WIDTH,
        height: Dp = HEIGHT,
        background: BackgroundState = BACKGROUND.copy(MaterialTheme.colorScheme.primaryContainer),
        border: BorderState = BORDER,
        padding: Dp = PADDING
    ): NodeProperties = NodeProperties(
        width = width,
        height = height,
        background = background,
        border = border,
        padding = padding
    )

    /**
     * 노드 미리보기의 속성.
     */
    @Composable
    fun preview(
        width: Dp = WIDTH,
        height: Dp = HEIGHT,
        background: BackgroundState = BACKGROUND.copy(MaterialTheme.colorScheme.secondaryContainer, alpha = 0.75F),
        border: BorderState = BORDER,
        padding: Dp = PADDING
    ): NodeProperties = NodeProperties(
        width = width,
        height = height,
        background = background,
        border = border,
        padding = padding
    )
}