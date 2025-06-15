package kr.lul.stringnotebook.preview.ui.template

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.template.MenuState
import kr.lul.stringnotebook.ui.template.ContextMenu
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
@Preview
fun ContextMenuPreview() {
    ComponentPreviewContainer(Modifier.size(400.dp), Alignment.TopStart) {
        ContextMenu(
            state = MenuState(100F, 200F),
            context = NotebookContext.NoOp,
            processor = EventProcessor.NoOp,
            onDismissRequest = {}
        )
    }
}