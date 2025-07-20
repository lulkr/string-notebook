package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor

@ExperimentalStdlibApi
val Brush.summary: String
    get() = when (this) {
        is SolidColor -> value.hex
        else -> toString()
    }