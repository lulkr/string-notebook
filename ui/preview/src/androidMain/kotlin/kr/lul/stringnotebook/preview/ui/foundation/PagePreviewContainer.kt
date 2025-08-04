package kr.lul.stringnotebook.preview.ui.foundation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme

@Composable
fun PagePreviewContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    StringNotebookTheme {
        Scaffold {
            Box(modifier.padding(it), Alignment.Center) {
                content()
            }
        }
    }
}