package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.foundation.Property.Companion.id
import kr.lul.stringnotebook.domain.type.SizePropertyType
import kr.lul.stringnotebook.domain.type.SizePropertyType.PROP_HEIGHT
import kr.lul.stringnotebook.domain.type.SizePropertyType.PROP_WIDTH
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 직사각형 크기.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class SizeProperty(
    id: Uuid = id(),
    name: String? = null,
    /**
     * 폭
     */
    val width: LengthProperty = LengthProperty(name = PROP_WIDTH),
    /**
     * 높이
     */
    val height: LengthProperty = LengthProperty(name = PROP_HEIGHT)
) : CompositeProperty(id, SizePropertyType, name, mapOf(PROP_WIDTH to width, PROP_HEIGHT to height)) {
    constructor(
        id: Uuid = id(),
        name: String? = null,
        width: Float = 0F,
        height: Float = 0F
    ) : this(
        id = id,
        name = name,
        width = LengthProperty(name = PROP_WIDTH, value = width),
        height = LengthProperty(name = PROP_WIDTH, value = height)
    )

    init {
        require(width.name == PROP_WIDTH)
        require(height.name == PROP_HEIGHT)
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "width=$width",
        "height=$height"
    ).joinToString(", ", "SizeProperty(", ")")
}