package kr.lul.stringnotebook.preview.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme

@Composable
fun ComponentPreviewContainer(content: @Composable () -> Unit) {
    StringNotebookTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            content()
        }
    }
}