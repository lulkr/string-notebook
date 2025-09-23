package kr.lul.stringnotebook.preview.state.molecule

import kr.lul.stringnotebook.state.atom.TextResource
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.name
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class TextStateProvider : PreviewParameterProvider<TextState> {
    override val values = sequenceOf(
        TextState("Hard-coded text"),
        TextState(resource = TextResource(Res.string.name)),
    )
}