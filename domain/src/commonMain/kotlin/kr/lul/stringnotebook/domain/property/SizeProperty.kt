package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.foundation.Property.Companion.id
import kr.lul.stringnotebook.domain.type.SizePropertyType
import kr.lul.stringnotebook.domain.type.SizePropertyType.HEIGHT
import kr.lul.stringnotebook.domain.type.SizePropertyType.WIDTH
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
    val width: LengthProperty = LengthProperty(name = WIDTH),
    /**
     * 높이
     */
    val height: LengthProperty = LengthProperty(name = HEIGHT)
) : CompositeProperty(id, SizePropertyType, name, mapOf(WIDTH to width, HEIGHT to height)) {
    constructor(
        id: Uuid = id(),
        name: String? = null,
        width: Float = 0F,
        height: Float = 0F
    ) : this(
        id = id,
        name = name,
        width = LengthProperty(name = WIDTH, value = width),
        height = LengthProperty(name = WIDTH, value = height)
    )

    init {
        require(width.name == WIDTH)
        require(height.name == HEIGHT)
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "width=$width",
        "height=$height"
    ).joinToString(", ", "SizeProperty(", ")")
}