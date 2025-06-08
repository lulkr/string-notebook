package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.atom.PositionState
import kr.lul.stringnotebook.state.atom.SizeState

/**
 * 화면에 보이는 것보다 큰 UI 컴포넌트를 화면에 표시할 때, 화면에 보이는 영역의 상태를 나타낸다.
 */
@Immutable
data class ViewportState(
    /**
     * 화면에 보이는 영역의 크기.
     */
    val size: SizeState = SizeState(),
    /**
     * 화면에 보이는 영역의 원 UI에서의 중심 위치.
     */
    val center: PositionState = PositionState()
)