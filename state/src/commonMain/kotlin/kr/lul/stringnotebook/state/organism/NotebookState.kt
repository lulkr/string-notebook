package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북
 */
@Immutable
@ExperimentalUuidApi
class NotebookState(
    val id: Uuid = Uuid.random(),
    val objects: List<ObjectState> = emptyList()
) {
    val anchors: List<AnchorState> = objects.filterIsInstance<AnchorState>()

    fun copy(
        objects: List<ObjectState> = this.objects
    ) = NotebookState(id, objects)

    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id &&
                    anchors == other.anchors
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + anchors.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "anchors=$anchors"
    ).joinToString(", ", "NotebookState(", ")")
}
