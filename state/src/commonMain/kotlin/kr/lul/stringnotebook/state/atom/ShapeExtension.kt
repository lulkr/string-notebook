package kr.lul.stringnotebook.state.atom

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape

val Shape.summary: String
    get() = when (this) {
        is RoundedCornerShape -> "RoundedCornerShape"
        else -> toString()
    }
