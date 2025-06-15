package kr.lul.stringnotebook.preview.state.organism

import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class AnchorStateProvider : PreviewParameterProvider<AnchorState> {
    data class PreviewState(
        val anchor: AnchorState,
        val context: NotebookContext
    )

    override val values = sequenceOf(
        AnchorState(x = 0, y = 0)
    )
}