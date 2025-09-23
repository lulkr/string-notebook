package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.state.organism.AnchorContainerParams
import kr.lul.stringnotebook.preview.state.organism.AnchorContainerParamsProvider
import kr.lul.stringnotebook.preview.ui.foundation.ComponentPreviewContainer
import kr.lul.stringnotebook.state.atom.inverse
import kr.lul.stringnotebook.ui.organism.AnchorContainer
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Preview
fun AnchorContainerPreview(@PreviewParameter(AnchorContainerParamsProvider::class) state: AnchorContainerParams) {
    ComponentPreviewContainer(Modifier.background(color = state.background).padding(8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.padding(8.dp), Alignment.Center) {
                AnchorContainer(state.anchor, state.zIndex, state.properties)
            }
            state.anchor.name?.let {
                Text(text = it, color = state.background.inverse, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}