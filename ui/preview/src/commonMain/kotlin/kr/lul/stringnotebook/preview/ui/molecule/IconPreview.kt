package kr.lul.stringnotebook.preview.ui.molecule

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.preview.state.molecule.IconStateProvider
import kr.lul.stringnotebook.state.molecule.IconState
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme
import kr.lul.stringnotebook.ui.molecule.Icon
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
@Preview
fun IconPreview(@PreviewParameter(IconStateProvider::class) icon: IconState) {
    StringNotebookTheme {
        Icon(icon)
    }
}