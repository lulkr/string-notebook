package kr.lul.stringnotebook.ui.molecule

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.AnchorContainerProperties
import kr.lul.stringnotebook.state.molecule.AnchorProperties
import kr.lul.stringnotebook.state.molecule.BackgroundState
import kr.lul.stringnotebook.state.molecule.BorderState

/**
 * [AnchorContainerProperties]의 기본값을 제공하는 객체입니다.
 */
object AnchorContainerPropertiesDefaults {
    /**
     * 테두리의 기본 너비.
     */
    val BORDER_WIDTH = 1.dp

    /**
     * 기본 여백.
     */
    val PADDING = 8.dp

    /**
     * 기본 상태.
     *
     * @param border 테두리.
     * @param background 배경.
     * @param padding 여백.
     * @param anchor 앵커 속성.
     */
    @Composable
    fun default(
        border: BorderState = BorderState(BORDER_WIDTH, Color.Transparent, CircleShape),
        background: BackgroundState = BackgroundState(Color.Transparent, CircleShape),
        padding: Dp = PADDING,
        anchor: AnchorProperties = AnchorPropertiesDefaults.default()
    ) = AnchorContainerProperties(border, background, padding, anchor)

    /**
     * 커서가 올라간 경우.
     *
     * @param border 테두리.
     * @param background 배경.
     * @param padding 여백.
     * @param anchor 앵커 속성.
     */
    @Composable
    fun hover(
        border: BorderState = BorderState(BORDER_WIDTH, MaterialTheme.colorScheme.outline, CircleShape),
        background: BackgroundState = BackgroundState(Color.Transparent, CircleShape),
        padding: Dp = PADDING,
        anchor: AnchorProperties = AnchorPropertiesDefaults.hover()
    ) = AnchorContainerProperties(border, background, padding, anchor)

    /**
     * 선택된 경우.
     *
     * @param border 테두리.
     * @param background 배경.
     * @param padding 여백.
     * @param anchor 앵커 속성.
     */
    @Composable
    fun focused(
        border: BorderState = BorderState(BORDER_WIDTH, MaterialTheme.colorScheme.primary, CircleShape),
        background: BackgroundState = BackgroundState(Color.Transparent, CircleShape),
        padding: Dp = PADDING,
        anchor: AnchorProperties = AnchorPropertiesDefaults.focused()
    ) = AnchorContainerProperties(border, background, padding, anchor)
}