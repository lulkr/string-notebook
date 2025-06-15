package kr.lul.stringnotebook.state.organism

import kr.lul.stringnotebook.state.molecule.AnchorColors

/**
 * 앵커 설정
 */
interface AnchorPreferences {
    object NoOp : AnchorPreferences {
        override val size: Float = 20F
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
