package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.organism.Anchor
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
@Preview
internal fun AnchorPreview() {
    val anchor = AnchorState(x = 0, y = 0, z = 0)

    ComponentPreviewContainer {
        Column {
            Anchor(anchor, PreviewNotebookContext.Default)

            Spacer(Modifier.height(16.dp))

            Anchor(anchor, PreviewNotebookContext.Default.copy(active = anchor))
        }
    }
}