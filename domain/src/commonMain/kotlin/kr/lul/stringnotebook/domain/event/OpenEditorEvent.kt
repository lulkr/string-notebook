package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 선택한 노드의 편집기를 엽니다.
 */
@ExperimentalUuidApi
class OpenEditorEvent(
    val target: Uuid
) : Event {
    override val id: Uuid = Uuid.random()

    override fun equals(other: Any?) = this === other || (
            other is OpenEditorEvent &&
                    id == other.id &&
                    target == other.target
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + target.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "target=$target"
    ).joinToString(", ", "OpenEditorEvent(", ")")
}