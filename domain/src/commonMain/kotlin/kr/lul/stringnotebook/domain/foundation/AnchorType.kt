package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_ANCHOR_TYPE
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 앵커 종류.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface AnchorType {
    companion object {
        internal fun id(suffix: Long) = ID_PREFIX_NOTEBOOK_ANCHOR_TYPE.generateId(suffix)
    }

    val id: Uuid

    val name: String

    val description: String
}