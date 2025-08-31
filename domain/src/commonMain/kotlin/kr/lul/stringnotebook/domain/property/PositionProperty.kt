package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.foundation.Property.Companion.id
import kr.lul.stringnotebook.domain.type.PositionPropertyType
import kr.lul.stringnotebook.domain.type.PositionPropertyType.PROP_X
import kr.lul.stringnotebook.domain.type.PositionPropertyType.PROP_Y
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
    val x: LengthProperty = LengthProperty(name = PROP_X),
    /**
     * Y 좌표.
     */
    val y: LengthProperty = LengthProperty(name = PROP_Y)
) : CompositeProperty(id, PositionPropertyType, name, mapOf(PROP_X to x, PROP_Y to y)) {
    constructor(
        id: Uuid = id(),
        name: String? = null,
        x: Float = 0F,
        y: Float = 0F
    ) : this(
        id = id,
        name = name,
        x = LengthProperty(name = PROP_X, value = x),
        y = LengthProperty(name = PROP_Y, value = y)
    )

    init {
        require(x.name == PROP_X)
        require(y.name == PROP_Y)
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "PositionProperty(", ")")
}