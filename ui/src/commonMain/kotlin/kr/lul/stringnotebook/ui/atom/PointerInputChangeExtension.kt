package kr.lul.stringnotebook.ui.atom

import androidx.compose.ui.input.pointer.PointerInputChange

val PointerInputChange.summary: String
    get() = "(id=$id, type=$type, position=$position, pressed=$pressed)"