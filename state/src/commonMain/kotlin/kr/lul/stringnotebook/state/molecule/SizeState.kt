package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable

@Immutable
data class SizeState(
    val width: Int = 0,
    val height: Int = 0
)
