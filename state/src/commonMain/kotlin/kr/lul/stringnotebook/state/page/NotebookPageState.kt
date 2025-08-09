package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 화면의 상태.
 *
 * @see NotebookPageHandler
 */
sealed interface NotebookPageState {
    companion object {
        /**
         * @see kr.lul.stringnotebook.domain.foundation.Notebook.id
         */
        const val ARG_NOTEBOOK_ID = "notebookId"
    }

    /**
     * 노트북 편집 화면을 열고, 노트북을 로드하는 중.
     */
    @ExperimentalUuidApi
    @Immutable
    data class Loading(
        val id: Uuid = NotebookState.Placeholder.id
    ) : NotebookPageState

    /**
     * 노트북 편집 화면이 로드되었으며, 노트북 편집이 가능한 상태.
     *
     * @param notebook 로드한 노트북 상태.
     */
    @ExperimentalUuidApi
    @Stable
    class Editing(
        val notebook: NotebookState = NotebookState.Placeholder,
    ) : NotebookPageState
}
