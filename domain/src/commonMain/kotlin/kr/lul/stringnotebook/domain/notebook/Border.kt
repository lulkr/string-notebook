package kr.lul.stringnotebook.domain.notebook

import kr.lul.stringnotebook.domain.property.ColorProperty
import kr.lul.stringnotebook.domain.property.LengthProperty
import kotlin.uuid.ExperimentalUuidApi

/**
 * 외곽선
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface Border {
    /**
     * 두께.
     */
    var width: LengthProperty

    /**
     * 색상.
     */
    var color: ColorProperty

    val summary: String
        get() = "Border(${width.value}, ${color.hex})"
}