package kr.lul.stringnotebook.state.organism

/**
 * 노트북의 편집 컨텍스트.
 */
interface NotebookContext {
    object NoOp : NotebookContext {
        override val preferences: NotebookPreferences = NotebookPreferences.NoOp
        override val active: ObjectState? = null
    }

    /**
     * 편집중인 노트북의 설정.
     */
    val preferences: NotebookPreferences

    /**
     * 현재 선택한 객체.
     */
    val active: ObjectState?
}