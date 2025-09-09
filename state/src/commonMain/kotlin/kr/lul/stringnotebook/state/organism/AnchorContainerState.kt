package kr.lul.stringnotebook.state.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState

/**
 * 앵커 컨테이너 기본값.
 */
@Immutable
data class AnchorContainerState(
    val border: BorderState,
    val padding: PaddingValues,
    val background: BackgroundState
) {
    companion object Companion {
        /**
         * 기본 패딩 값. DP 단위.
         */
        const val PADDING = 8
    }
}