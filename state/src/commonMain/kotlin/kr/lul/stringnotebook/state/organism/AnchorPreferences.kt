package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.molecule.AnchorColors

/**
 * 앵커 설정
 */
@Stable
interface AnchorPreferences {
    object Default : AnchorPreferences {
        override val size: Float = 8F
        override val colors: AnchorColors = AnchorColors()
    }

    /**
     * 크기.
     */
    val size: Float

    /**
     * 색상.
     */
    val colors: AnchorColors
}
