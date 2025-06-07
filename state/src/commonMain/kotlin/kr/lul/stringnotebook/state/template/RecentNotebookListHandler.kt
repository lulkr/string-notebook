package kr.lul.stringnotebook.state.template

import kr.lul.stringnotebook.state.molecule.RecentNotebookState

/**
 * 최근 노트북 목록의 핸들러.
 *
 * @see RecentNotebookListState
 */
interface RecentNotebookListHandler {
    object NoOp : RecentNotebookListHandler {
        override fun onClickClear() = Unit
        override fun onClickRecentProject(project: RecentNotebookState) = Unit
    }

    /**
     * 목록 비우기.
     */
    fun onClickClear()

    /**
     * 최근 노트북 선택.
     */
    fun onClickRecentProject(project: RecentNotebookState)
}