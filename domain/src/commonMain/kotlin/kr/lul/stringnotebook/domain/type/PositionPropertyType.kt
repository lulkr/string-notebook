package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.CompositePropertyType
import kr.lul.stringnotebook.domain.type.PositionPropertyType.ID_SUFFIX
import kr.lul.stringnotebook.domain.type.PositionPropertyType.PROP_X
import kr.lul.stringnotebook.domain.type.PositionPropertyType.PROP_Y
import kotlin.uuid.ExperimentalUuidApi

/**
 * 좌표.
 * 오브젝트를 배치할 때 사용하는 좌표.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
object PositionPropertyType : CompositePropertyType(
    id = id(ID_SUFFIX),
    name = "Position",
    description = "오브젝트를 배치할 때 사용하는 좌표.",
    properties = mapOf(
        PROP_X to LengthPropertyType,
        PROP_Y to LengthPropertyType
    )
) {
    const val ID_SUFFIX = 2L
    const val PROP_X = "x"
    const val PROP_Y = "y"

    /**
     * x 좌표
     */
    val x = LengthPropertyType

    /**
     * y 좌표
     */
    val y = LengthPropertyType
}