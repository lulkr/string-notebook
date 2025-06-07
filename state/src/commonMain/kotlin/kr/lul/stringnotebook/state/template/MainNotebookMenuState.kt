package kr.lul.stringnotebook.state.template

import androidx.compose.runtime.Immutable

/**
 * 메인 화면의 작업할 노트북을 선택 영역.
 *
 * @see MainNotebookMenuHandler
 */
@Immutable
data class MainNotebookMenuState(
    /**
     * 최근 노트북 목록.
     */
    val recent: RecentNotebookListState = RecentNotebookListState()
)
