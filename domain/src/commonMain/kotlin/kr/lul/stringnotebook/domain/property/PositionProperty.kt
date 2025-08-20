package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.foundation.Property.Companion.id
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
    id: Uuid = id(),
    name: String? = null,
    /**
     * X 좌표.
     */
    val x: LengthProperty = LengthProperty(name = X),
    /**
     * Y 좌표.
     */
    val y: LengthProperty = LengthProperty(name = Y)
) : CompositeProperty(id, PositionPropertyType, name, mapOf(X to x, Y to y)) {
    constructor(
        id: Uuid = id(),
        name: String? = null,
        x: Float = 0F,
        y: Float = 0F
    ) : this(
        id = id,
        name = name,
        x = LengthProperty(name = X, value = x),
        y = LengthProperty(name = Y, value = y)
    )

    init {
        require(x.name == X)
        require(y.name == Y)
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "PositionProperty(", ")")
}