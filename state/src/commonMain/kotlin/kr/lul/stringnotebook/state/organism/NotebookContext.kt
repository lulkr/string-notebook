package kr.lul.stringnotebook.state.organism

/**
 * 노트북의 편집 컨텍스트.
 */
interface NotebookContext {
    object NoOp : NotebookContext {
        override val preferences: NotebookPreferences = NotebookPreferences.NoOp
        override val lock: Boolean = false
        override val active: ObjectState? = null
    }

    /**
     * 편집중인 노트북의 설정.
     */
    val preferences: NotebookPreferences

    /**
     * 노트북 자체의 잠금상태. `true`이면 편집이 불가능하다.
     */
    val lock: Boolean

    /**
     * 현재 선택한 객체.
     */
    val active: ObjectState?
}