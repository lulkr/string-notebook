package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.organism.NotebookState

/**
 * @see NotebookPageHandler
 */
sealed interface NotebookPageState {
    /**
     * 초기값.
     */
    @Immutable
    data object Initial : NotebookPageState

    /**
     * 노트북 데이터를 읽고 상태 초기화 하는 중.
     */
    @Immutable
    data object Loading : NotebookPageState

    /**
     * 노트북 페이지가 준비된 상태.
     */
    @Immutable
    data class Editing(
        val notebook: NotebookState
    ) : NotebookPageState
}