package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.EventType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
enum class StandardEventType : EventType {
    /**
     * 노트북에 앵커 추가.
     */
    ADD_ANCHOR,

    /**
     * 앵커 위치 이동.
     */
    MOVE_ANCHOR,

    /**
     * 앵커 제거.
     */
    REMOVE_ANCHOR;

    override val id: Uuid = EventType.id(ordinal + 1)
}