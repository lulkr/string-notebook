package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.ScalarPropertyType
import kr.lul.stringnotebook.domain.type.LengthPropertyType.ID_SUFFIX
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
object LengthPropertyType : ScalarPropertyType(
    id = id(ID_SUFFIX),
    name = "Length",
    description = "길이를 표현하는 속성 타입"
) {
    const val ID_SUFFIX = 0L
}