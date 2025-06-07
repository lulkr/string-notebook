package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_TYPE_ANCHOR
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi

/**
 * [Anchor]의 종류.
 */
interface AnchorType : ObjectType {
    @OptIn(ExperimentalStdlibApi::class, ExperimentalUuidApi::class)
    companion object {
        fun id(suffix: Int) = ID_PREFIX_TYPE_ANCHOR.generateId(suffix)
    }
}