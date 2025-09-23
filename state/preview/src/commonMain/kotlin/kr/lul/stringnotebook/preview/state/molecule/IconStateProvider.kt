package kr.lul.stringnotebook.preview.state.molecule

import kr.lul.stringnotebook.state.molecule.IconState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.icon_new_notebook
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class IconStateProvider : PreviewParameterProvider<IconState> {
    override val values = sequenceOf(
        IconState(icon = Res.drawable.icon_new_notebook)
    )
}