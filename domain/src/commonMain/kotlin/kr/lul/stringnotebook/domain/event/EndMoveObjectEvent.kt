package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 객체 이동 종료 이벤트.
 *
 * 이 이벤트는 객체를 이동할 때 사용됩니다.
 *
 * @property id 이벤트의 고유 식별자. 기본값은 무작위로 생성됩니다.
 * @property target 이동할 대상 객체의 ID.
 */
@ExperimentalUuidApi
class EndMoveObjectEvent(
    val target: Uuid
) : Event {
    override val id: Uuid = Uuid.random()
}