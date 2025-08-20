package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.foundation.AnchorType.Companion.id
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
object PlainAnchorType : AnchorType {
    override val id = id(0L)
    override val name = "Plain"
    override val description = "추가적인 요소 없이 단순히 위치만 가지는 앵커."
    override fun toString() = name
}