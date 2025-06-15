package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 이벤트.
 */
@OptIn(ExperimentalUuidApi::class)
interface Event {
    /**
     * 이벤트 식별자.
     */
    val id: Uuid
}