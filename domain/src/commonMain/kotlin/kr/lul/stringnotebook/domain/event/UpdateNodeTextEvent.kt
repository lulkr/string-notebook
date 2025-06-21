package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노드의 내용을 수정하기.
 *
 * @property target 수정할 노드의 ID.
 * @property text 새로운 내용.
 */
@ExperimentalUuidApi
data class UpdateNodeTextEvent(
    val target: Uuid,
    val text: String
) : Event {
    override val id: Uuid = Uuid.random()

    override fun equals(other: Any?) = this === other || (
            other is UpdateNodeTextEvent &&
                    id == other.id &&
                    target == other.target &&
                    text == other.text
            )

    override fun hashCode(): Int {
        var result = target.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "target=$target",
        "text=$text"
    ).joinToString(", ", "UpdateNodeTextEvent(", ")")
}