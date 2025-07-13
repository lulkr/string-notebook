package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 객체를 활성화하는 이벤트. 활성화한 객체만 수정할 수 있다.
 *
 * @property target 활성화할 객체의 ID.
 *
 * @see DeactivateEvent
 */
@ExperimentalUuidApi
data class ObjectFocusEvent(
    val target: Uuid
) : Event {
    override val id: Uuid = Uuid.random()

    override fun equals(other: Any?) = this === other || (
            other is ObjectFocusEvent &&
                    id == other.id &&
                    target == other.target
            )

    override fun hashCode(): Int {
        var result = target.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

    override fun toString() = "ActivateEvent(id=$id, target=$target)"
}