package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.CompositeType
import kr.lul.stringnotebook.domain.type.SizeType.HEIGHT
import kr.lul.stringnotebook.domain.type.SizeType.ID_SUFFIX
import kr.lul.stringnotebook.domain.type.SizeType.WIDTH
import kotlin.uuid.ExperimentalUuidApi

/**
 * 크기를 가진 오브젝트를 감싸는 직사각형의 크기를 표현하는 속성 타입
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
object SizeType : CompositeType(
    id = id(ID_SUFFIX),
    name = "Size",
    description = "크기를 가진 오브젝트를 감싸는 직사각형의 크기를 표현하는 속성 타입",
    properties = mapOf(
        WIDTH to LengthType,
        HEIGHT to LengthType
    )
) {
    const val ID_SUFFIX = 1L
    const val WIDTH = "width"
    const val HEIGHT = "height"

    /**
     * 폭
     */
    val width = LengthType

    /**
     * 높이
     */
    val height = LengthType
}