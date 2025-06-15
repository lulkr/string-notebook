package kr.lul.stringnotebook.state.organism

/**
 * 노트북 설정.
 */
interface NotebookPreferences {
    object NoOp : NotebookPreferences {
        override val anchor: AnchorPreferences = AnchorPreferences.NoOp
    }

    /**
     * 앵커 설정.
     */
    val anchor: AnchorPreferences
}
