package kr.lul.stringnotebook.ui.molecule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.AnchorContainerProperties
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
    val PADDING = PaddingValues(8.dp)

    /**
     * 기본.
     */
    @Composable
    fun default(
        border: BorderState = BorderState(BORDER_WIDTH, Color.Transparent, CircleShape),
        background: BackgroundState = BackgroundState(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
        padding: PaddingValues = PADDING
    ) = AnchorContainerProperties(border, background, padding)

    /**
     * 커서가 위에 있는 경우.
     */
    @Composable
    fun hover(
        border: BorderState = BorderState(BORDER_WIDTH, MaterialTheme.colorScheme.outline, CircleShape),
        background: BackgroundState = BackgroundState(MaterialTheme.colorScheme.secondaryContainer, CircleShape),
        padding: PaddingValues = PADDING
    ) = AnchorContainerProperties(border, background, padding)

    /**
     * 선택된 경우.
     */
    @Composable
    fun focused(
        border: BorderState = BorderState(BORDER_WIDTH, MaterialTheme.colorScheme.primary, CircleShape),
        background: BackgroundState = BackgroundState(Color.Transparent, CircleShape),
        padding: PaddingValues = PADDING
    ) = AnchorContainerProperties(border, background, padding)
}