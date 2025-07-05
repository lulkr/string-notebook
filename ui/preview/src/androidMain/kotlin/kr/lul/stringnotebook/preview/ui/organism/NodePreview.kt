@file:OptIn(ExperimentalUuidApi::class)

package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.ObjectActivatedContext
import kr.lul.stringnotebook.ui.organism.Node
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@Preview
fun NodePreview() {
    val node = NodeState(x = 0, y = 0, z = 0)
    ComponentPreviewContainer {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Node(node, NeutralContext())
            Node(node.copy(text = "node content"), NeutralContext())
            Node(node, ObjectActivatedContext(active = node))
            node.copy(text = "node content").let {
                Node(it, ObjectActivatedContext(active = node))
            }
        }
    }
}