package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 비활성화 이벤트.
 *
 * 이 이벤트는 오브젝트를 비활성화할 때 사용됩니다.
 *
 * @property id 이벤트의 고유 식별자. 기본값은 무작위로 생성됩니다.
 *
 * @see ActivateEvent
 */
@ExperimentalUuidApi
class DeactivateEvent(
    override val id: Uuid = Uuid.random()
) : Event