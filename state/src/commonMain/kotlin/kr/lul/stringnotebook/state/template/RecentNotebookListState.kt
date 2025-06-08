package kr.lul.stringnotebook.state.template

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.organism.RecentNotebookState

/**
 * 최근 노트북 목록.
 *
 * @see RecentNotebookListHandler
 */
@Immutable
data class RecentNotebookListState(
    /**
     * 최근 열어본 노트북 목록.
     */
    val notebooks: List<RecentNotebookState> = emptyList()
)