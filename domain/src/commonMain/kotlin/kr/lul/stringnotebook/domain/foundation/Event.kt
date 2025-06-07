package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 사용자가 발생시킨 이벤트.
 */
@OptIn(ExperimentalUuidApi::class)
interface Event {
    /**
     * 이벤트 ID.
     */
    val id: Uuid

    /**
     * 이벤트 타입.
     */
    val type: EventType
}