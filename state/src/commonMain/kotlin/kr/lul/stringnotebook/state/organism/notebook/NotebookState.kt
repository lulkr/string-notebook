package kr.lul.stringnotebook.state.organism.notebook

import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [Notebook]를 나타내는 상태 홀더.
 */
@ExperimentalUuidApi
@Stable
class NotebookState(
    /**
     * @see Notebook.id
     */
    val id: Uuid
) {
    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id
            )

    override fun hashCode() = id.hashCode()

    override fun toString() = listOf(
        "id=$id"
    ).joinToString(", ", "NotebookState(", ")")
}
