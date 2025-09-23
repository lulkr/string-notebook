package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.graphics.Color

@ExperimentalStdlibApi
val colorChannelHexFormat: HexFormat = HexFormat {
    number.removeLeadingZeros = true
    upperCase = true
}

@ExperimentalStdlibApi
val Color.redHex: String
    get() = (255 * red).toInt().toHexString(colorChannelHexFormat)

@ExperimentalStdlibApi
val Color.greenHex: String
    get() = (255 * green).toInt().toHexString(colorChannelHexFormat)

@ExperimentalStdlibApi
val Color.blueHex: String
    get() = (255 * blue).toInt().toHexString(colorChannelHexFormat)

@ExperimentalStdlibApi
val Color.alphaHex: String
    get() = (255 * alpha).toInt().toHexString(colorChannelHexFormat)

@ExperimentalStdlibApi
val Color.hex: String
    get() = "#${redHex}${greenHex}${blueHex}${alphaHex}"

val Color.inverse: Color
    get() = Color(1 - red, 1 - green, 1 - blue, alpha)