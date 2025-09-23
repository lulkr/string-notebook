package kr.lul.stringnotebook.preview.ui.molecule

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.preview.state.molecule.TextStateProvider
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme
import kr.lul.stringnotebook.ui.molecule.Text
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
@Preview
fun TextPreview(@PreviewParameter(TextStateProvider::class) state: TextState) {
    StringNotebookTheme {
        Text(state)
    }
}