package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 컨텍스트 메뉴 숨기기.
 */
@ExperimentalUuidApi
class HideContextMenuEvent : Event {
    override val id: Uuid = Uuid.random()

    override fun equals(other: Any?) = this === other || (
            other is HideContextMenuEvent &&
                    id == other.id
            )

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString() = "HideContextMenuEvent(id=$id)"
}
