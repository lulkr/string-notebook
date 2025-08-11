package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.CompositeType
import kr.lul.stringnotebook.domain.type.PositionType.ID_SUFFIX
import kr.lul.stringnotebook.domain.type.PositionType.X
import kr.lul.stringnotebook.domain.type.PositionType.Y
import kotlin.uuid.ExperimentalUuidApi

/**
 * 좌표.
 * 오브젝트를 배치할 때 사용하는 좌표.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
object PositionType : CompositeType(
    id = id(ID_SUFFIX),
    name = "Position",
    description = "오브젝트를 배치할 때 사용하는 좌표.",
    properties = mapOf(
        X to LengthType,
        Y to LengthType
    )
) {
    const val ID_SUFFIX = 2L
    const val X = "x"
    const val Y = "y"

    /**
     * x 좌표
     */
    val x = LengthType

    /**
     * y 좌표
     */
    val y = LengthType
}