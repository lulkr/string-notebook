package kr.lul.stringnotebook.state.organism.notebook

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
    val id: Uuid,
    name: String,
    description: String?
) {
    companion object {
        val Placeholder = NotebookState(
            Uuid.parse("00000000-0000-0000-0000-000000000000"),
            "플레이스홀더 노트북",
            null
        )
    }

    var name: String by mutableStateOf(name)
    var description: String? by mutableStateOf(description)

    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id &&
                    name == other.name &&
                    description == other.description
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "description=${description?.let { "'$it'" }}"
    ).joinToString(", ", "NotebookState(", ")")
}
