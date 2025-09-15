package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.organism.AnchorContainerState
import kr.lul.stringnotebook.state.organism.AnchorContainerState.Companion.PADDING

/**
 * 앵커 컨테이너의 기본 상태값과 유틸리티 메서드.
 */
@Deprecated("use kr.lul.stringnotebook.state.organism.AnchorProperties")
object AnchorContainerDefaults {
    /**
     * 기본 앵커 컨테이너.
     *
     * 사용자 상호작용이 없는 기본 상태.
     */
    @Composable
    fun default(
        border: BorderState = BorderState(1.dp, Color.Transparent, CircleShape),
        background: BackgroundState = BackgroundState(),
        padding: PaddingValues = PaddingValues(PADDING.dp)
    ) = AnchorContainerState(border, background, padding)

    /**
     * 호버 앵커 컨테이너.
     *
     * 마우스 커서 등이 앵커 컨테이너 위에 올라왔을 때 사용.
     */
    @Composable
    fun hovered(
        border: BorderState = BorderState(1.dp, MaterialTheme.colorScheme.secondary, CircleShape),
        background: BackgroundState = BackgroundState(),
        padding: PaddingValues = PaddingValues(PADDING.dp)
    ) = AnchorContainerState(border, background, padding)

    /**
     * 선택된 앵커 컨테이너.
     *
     * 사용자가 앵커 컨테이너를 조작하기 위해 선택했을 때 사용.
     */
    @Composable
    fun selected(
        border: BorderState = BorderState(1.dp, MaterialTheme.colorScheme.primary, CircleShape),
        background: BackgroundState = BackgroundState(),
        padding: PaddingValues = PaddingValues(PADDING.dp)
    ) = AnchorContainerState(border, background, padding)
}