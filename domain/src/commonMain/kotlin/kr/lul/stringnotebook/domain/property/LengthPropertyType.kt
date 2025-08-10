package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.ScalarPropertyType
import kr.lul.stringnotebook.domain.property.LengthPropertyType.ID_POSTFIX
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
object LengthPropertyType : ScalarPropertyType(
    id = id(ID_POSTFIX),
    name = "length",
    description = "길이를 표현하는 속성 타입"
) {
    const val ID_POSTFIX = 0L
}