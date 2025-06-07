package kr.lul.stringnotebook.state.template

/**
 * 메인 화면의 작업할 노트북을 선택 영역의 핸들러.
 *
 * @see MainNotebookMenuState
 */
interface MainNotebookMenuHandler {
    object NoOp : MainNotebookMenuHandler {
        override fun onClickNewNotebook() = Unit
    }

    /**
     * 새 노트북을 생성하는 버튼 클릭 이벤트.
     */
    fun onClickNewNotebook()
}