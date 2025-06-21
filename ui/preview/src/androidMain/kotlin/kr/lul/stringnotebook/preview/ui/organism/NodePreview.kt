@file:OptIn(ExperimentalUuidApi::class)

package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.preview.ui.organism.PreviewNotebookContext.Companion.Default
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.ui.organism.Node
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@Preview
fun NodePreview() {
    val default = NodeState(x = 0, y = 0, z = 0)
    ComponentPreviewContainer {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Node(default, Default)
            Node(default.copy(text = "node content"), Default)
            Node(default, Default.copy(active = default))
            default.copy(text = "node content").let {
                Node(it, Default.copy(active = it))
            }
        }
    }
}