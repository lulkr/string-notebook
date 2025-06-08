package kr.lul.stringnotebook.state.atom

import androidx.compose.runtime.Immutable

@Immutable
data class SizeState(
    val width: Int = 0,
    val height: Int = 0
)
