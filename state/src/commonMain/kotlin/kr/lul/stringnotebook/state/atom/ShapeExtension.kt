package kr.lul.stringnotebook.state.atom

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape

val Shape.summary: String
    get() = when (this) {
        is RoundedCornerShape -> if (setOf(topStart, topEnd, bottomEnd, bottomStart).size == 1) {
            "RoundedCornerShape($topStart)"
        } else {
            "RoundedCornerShape($topStart,$topEnd,$bottomEnd,$bottomStart)"
        }

        else -> toString()
    }
