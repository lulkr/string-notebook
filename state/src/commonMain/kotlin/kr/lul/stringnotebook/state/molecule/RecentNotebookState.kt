package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 최근 프로젝트.
 *
 * @see RecentNotebookHandler
 */
@Immutable
@OptIn(ExperimentalUuidApi::class)
data class RecentNotebookState(
    /**
     * @see kr.lul.stringnotebook.domain.foundation.StringNotebook.id
     */
    val uuid: Uuid,

    /**
     * @see kr.lul.stringnotebook.domain.foundation.StringNotebook.name
     */
    val name: String,

    )