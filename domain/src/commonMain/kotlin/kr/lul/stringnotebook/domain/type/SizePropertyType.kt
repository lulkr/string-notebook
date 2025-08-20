package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.CompositePropertyType
import kr.lul.stringnotebook.domain.type.SizePropertyType.HEIGHT
import kr.lul.stringnotebook.domain.type.SizePropertyType.ID_SUFFIX
import kr.lul.stringnotebook.domain.type.SizePropertyType.WIDTH
import kotlin.uuid.ExperimentalUuidApi

/**
 * 크기를 가진 오브젝트를 감싸는 직사각형의 크기를 표현하는 속성 타입
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
object SizePropertyType : CompositePropertyType(
    id = id(ID_SUFFIX),
    name = "Size",
    description = "크기를 가진 오브젝트를 감싸는 직사각형의 크기를 표현하는 속성 타입",
    properties = mapOf(
        WIDTH to LengthPropertyType,
        HEIGHT to LengthPropertyType
    )
) {
    const val ID_SUFFIX = 1L
    const val WIDTH = "width"
    const val HEIGHT = "height"

    /**
     * 폭
     */
    val width = LengthPropertyType

    /**
     * 높이
     */
    val height = LengthPropertyType
}