package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import kr.lul.stringnotebook.state.molecule.WyswigEditorColors
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.WyswigEditorState
import kr.lul.stringnotebook.ui.molecule.WyswigEditorDefault

@Composable
fun WyswigEditor(
    notebook: NotebookState,
    state: WyswigEditorState,
    modifier: Modifier = Modifier,
    colors: WyswigEditorColors = WyswigEditorDefault.colors()
) {
    Box(modifier = modifier.background(colors.background)) {
        Layout(
            content = {
                for (anchor in notebook.anchors) {

                }
            }
        ) { measurables, constraints ->
            layout(constraints.maxWidth, constraints.maxHeight) {
            }
        }
    }
}