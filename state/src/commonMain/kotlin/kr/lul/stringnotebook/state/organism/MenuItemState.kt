package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable

@Immutable
data class MenuItemState(
    val label: String,
    val action: () -> Unit = { },
)
