package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북
 *
 * @property id 노트북의 고유 식별자.
 * @property objects 노트북에 포함된 객체들의 리스트.
 * @property anchors 노트북에 포함된 앵커 객체들의 리스트. [objects]에 포함됨.
 * @property nodes 노트북에 포함된 노드 객체들의 리스트. [objects]에 포함됨.
 */
@ExperimentalUuidApi
@Stable
class NotebookState(
    val id: Uuid = Uuid.random(),
    val objects: List<ObjectState> = emptyList()
) {
    val anchors: List<AnchorState> = objects.filterIsInstance<AnchorState>()

    val nodes: List<NodeState> = objects.filterIsInstance<NodeState>()

    fun copy(
        objects: List<ObjectState> = this.objects
    ) = NotebookState(id, objects)

    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id &&
                    objects == other.objects
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + objects.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "anchors=$anchors",
        "nodes=$nodes"
    ).joinToString(", ", "NotebookState(", ")")
}
