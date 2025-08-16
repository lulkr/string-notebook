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
) : CompositeProperty(
    id = id,
    type = SizeType,
    name = name,
    children = mapOf(
        WIDTH to width,
        HEIGHT to height
    )
) {
    constructor(name: String, width: Float, height: Float) : this(
        id = Uuid.random(),
        name = name,
        width = LengthProperty(WIDTH, 0F),
        height = LengthProperty(WIDTH, 0F)
    )
}