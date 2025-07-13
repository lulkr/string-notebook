package kr.lul.stringnotebook.state.molecule

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable

@Immutable
data class AnchorContainerProperties(
    val border: BorderState,
    val background: BackgroundState,
    val padding: PaddingValues
)
