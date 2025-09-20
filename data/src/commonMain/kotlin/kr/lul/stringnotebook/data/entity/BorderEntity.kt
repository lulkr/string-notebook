package kr.lul.stringnotebook.data.entity

import kr.lul.stringnotebook.domain.notebook.Border
import kr.lul.stringnotebook.domain.property.ColorProperty
import kr.lul.stringnotebook.domain.property.LengthProperty
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
class BorderEntity(
    override var width: LengthProperty,
    override var color: ColorProperty
) : Border {
    constructor(width: Float = 1F, red: Int = 0, green: Int = 0, blue: Int = 0, alpha: Int = 255) : this(
        LengthProperty(name = "width", value = width),
        ColorProperty(
            name = "color",
            red = red,
            green = green,
            blue = blue,
            alpha = alpha
        )
    )

    override fun equals(other: Any?) = this === other || (
            other is Border &&
                    width == other.width &&
                    color == other.color
            )

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + color.hashCode()
        return result
    }

    override fun toString() = listOf(
        "width=$width",
        "color=$color"
    ).joinToString(", ", "BorderEntity(", ")")
}