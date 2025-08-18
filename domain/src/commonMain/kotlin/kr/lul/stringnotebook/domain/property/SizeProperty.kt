package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.CompositeProperty
import kr.lul.stringnotebook.domain.type.SizeType
import kr.lul.stringnotebook.domain.type.SizeType.HEIGHT
import kr.lul.stringnotebook.domain.type.SizeType.WIDTH
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 직사각형 크기.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class SizeProperty(
    id: Uuid,
    name: String,
    /**
     * 폭
     */
    val width: LengthProperty,
    /**
     * 높이
     */
    val height: LengthProperty
) : CompositeProperty(id, SizeType, name, mapOf(WIDTH to width, HEIGHT to height)) {
    constructor(
        name: String,
        width: LengthProperty,
        height: LengthProperty
    ) : this(Uuid.random(), name, width, height)

    constructor(
        name: String,
        width: Float,
        height: Float
    ) : this(Uuid.random(), name, LengthProperty(WIDTH, width), LengthProperty(WIDTH, height))

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "width=$width",
        "height=$height"
    ).joinToString(", ", "SizeProperty(", ")")
}