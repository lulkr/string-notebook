package kr.lul.stringnotebook.preview.ui.template

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookFocusedContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.template.NotebookEditor
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi

@Composable
@Preview
@ExperimentalUuidApi
fun NotebookPreview() {
    val notebook = NotebookState(
        objects = (0..10).map { AnchorState(x = 100 * it, y = 100 * it) } +
                (0..10).map { AnchorState(x = 100 * Random.nextInt(10), y = 100 * Random.nextInt(10)) }
    )

    ComponentPreviewContainer(Modifier.fillMaxSize()) {
        NotebookEditor(notebook, NotebookFocusedContext(), EventProcessor.NoOp)
    }
}