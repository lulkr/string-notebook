package kr.lul.stringnotebook.state.atom

import androidx.compose.runtime.Immutable

@Immutable
data class PositionState(
    val x: Int = 0,
    val y: Int = 0
)
