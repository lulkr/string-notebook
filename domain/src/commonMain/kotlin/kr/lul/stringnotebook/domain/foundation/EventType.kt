package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_TYPE_EVENT
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
interface EventType {
    @OptIn(ExperimentalStdlibApi::class)
    companion object {
        fun id(suffix: Int) = ID_PREFIX_TYPE_EVENT.generateId(suffix)
    }

    /**
     * 이벤트 타입 ID.
     */
    val id: Uuid
}