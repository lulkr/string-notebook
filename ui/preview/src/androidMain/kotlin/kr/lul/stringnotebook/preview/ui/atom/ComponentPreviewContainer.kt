package kr.lul.stringnotebook.preview.ui.atom

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme

@Composable
fun ComponentPreviewContainer(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable () -> Unit
) {
    StringNotebookTheme {
        Box(modifier, contentAlignment) {
            content()
        }
    }
}