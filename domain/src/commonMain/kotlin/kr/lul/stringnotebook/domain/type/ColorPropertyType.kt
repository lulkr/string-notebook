package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.ScalarPropertyType
import kr.lul.stringnotebook.domain.type.ColorPropertyType.ID_SUFFIX
import kotlin.uuid.ExperimentalUuidApi

/**
 * RGBA 색상.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
object ColorPropertyType : ScalarPropertyType(
    id = id(ID_SUFFIX),
    name = "Color",
    description = "색상을 표현하는 속성 타입."
) {
    const val ID_SUFFIX = 3L
}