package kr.lul.stringnotebook.state.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState

/**
 * [kr.lul.stringnotebook.domain.foundation.Anchor]를 화면에 표시하기 위한 속성.
 *
 */
@Immutable
class AnchorProperties(
    /**
     * 앵커 컨테이너의 테두리 상태.
     */
    val containerBorder: BorderState,
    /**
     * 앵커 컨테이너의 배경 상태.
     */
    val containerBackground: BackgroundState,
    /**
     * 앵커 컨테이너의 패딩.
     *
     * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
     *
     * @see radius
     */
    val containerPadding: PaddingValues,
    /**
     * 앵커의 배경 상태.
     */
    val background: BackgroundState,
    /**
     * 앵커의 반지름.
     *
     * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
     *
     * @see containerPadding
     */
    val radius: Dp
)