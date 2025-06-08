package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.atom.SizeState

@Immutable
data class NotebookMetadataState(
    val size: SizeState
)
