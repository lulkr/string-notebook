package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.ObjectActivatedContext
import kr.lul.stringnotebook.ui.organism.Anchor
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
@Preview
internal fun AnchorPreview() {
    val anchor = AnchorState(x = 0, y = 0, z = 0)

    ComponentPreviewContainer {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Anchor(anchor, NeutralContext())
            Anchor(anchor, ObjectActivatedContext(active = anchor))
        }
    }
}