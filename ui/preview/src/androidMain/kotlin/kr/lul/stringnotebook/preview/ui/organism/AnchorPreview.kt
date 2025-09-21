package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.state.organism.AnchorStateProvider
import kr.lul.stringnotebook.preview.ui.foundation.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.organism.Anchor
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Preview
fun AnchorPreview(@PreviewParameter(AnchorStateProvider::class) anchor: AnchorState) {
    ComponentPreviewContainer(Modifier.padding(8.dp)) {
        Anchor(anchor, 4.dp, MaterialTheme.colorScheme.primaryContainer)
    }
}