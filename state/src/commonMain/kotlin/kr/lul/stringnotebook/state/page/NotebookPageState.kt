package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 화면의 상태.
 *
 * @see NotebookPageHandler
 */
@ExperimentalUuidApi
@Stable
data class NotebookPageState(
    val notebook: NotebookState = NotebookState(Uuid.parse("00000000-0000-0000-0000-000000000000"), "플레이스홀더 노트북", null)
)
