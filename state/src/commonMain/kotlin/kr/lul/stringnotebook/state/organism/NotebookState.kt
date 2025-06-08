package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable

/**
 * 노트북의 UI 상태.
 *
 * @see kr.lul.stringnotebook.domain.foundation.StringNotebook
 */
@Immutable
data class NotebookState(
    /**
     * @see kr.lul.stringnotebook.domain.foundation.StringNotebook.anchors
     */
    val anchors: List<AnchorState>
)
