package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.type.PositionPropertyType
import kr.lul.stringnotebook.domain.type.PositionPropertyType.X
import kr.lul.stringnotebook.domain.type.PositionPropertyType.Y
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 위치.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class PositionProperty(
    id: Uuid,
    name: String,
    /**
     * X 좌표.
     */
    val x: LengthProperty,
    /**
     * Y 좌표.
     */
    val y: LengthProperty
) : CompositeProperty(id, PositionPropertyType, name, mapOf(X to x, Y to y)) {
    constructor(name: String, x: Float, y: Float) : this(
        id = Uuid.random(),
        name = name,
        x = LengthProperty(X, x),
        y = LengthProperty(Y, y)
    )

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "PositionProperty(", ")")
}