package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 두 오브젝트를 연결하는 이벤트.
 *
 * @property from 연결의 시작 오브젝트의 [Event.id].
 * @property to 연결의 끝 오브젝트의 [Event.id].
 */
@ExperimentalUuidApi
data class LinkObjectEvent(
    val from: Uuid,
    val to: Uuid
) : Event {
    override val id = Uuid.random()

    override fun toString() = "LinkObjectEvent(id=$id, from=$from, to=$to)"
}
