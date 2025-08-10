package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.ScalarType
import kr.lul.stringnotebook.domain.type.LengthType.ID_SUFFIX
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
object LengthType : ScalarType(
    id = id(ID_SUFFIX),
    name = "length",
    description = "길이를 표현하는 속성 타입"
) {
    const val ID_SUFFIX = 0L
}