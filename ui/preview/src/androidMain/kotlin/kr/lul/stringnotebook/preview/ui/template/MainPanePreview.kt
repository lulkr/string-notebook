package kr.lul.stringnotebook.preview.ui.template

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.ShowContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.preview.ui.atom.ComponentPreviewContainer
import kr.lul.stringnotebook.preview.ui.organism.PreviewNotebookContext
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.template.MenuState
import kr.lul.stringnotebook.ui.template.MainPane
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi

@Composable
@Preview
@ExperimentalUuidApi
fun MainPanePreview() {
    var notebook = NotebookState(
        objects = (0..10).map { AnchorState(x = 100 * it, y = 100 * it) } +
                (0..10).map { AnchorState(x = 100 * Random.nextInt(10), y = 100 * Random.nextInt(10)) }
    )
    var context = PreviewNotebookContext()
    context.active = notebook.objects.random()

    val processor = object : EventProcessor {
        override fun invoke(event: Event) {
            when (event) {
                is ShowContextMenuEvent ->
                    context = context.copy(
                        menu = MenuState(event.x, event.y)
                    )

                is HideContextMenuEvent ->
                    context = context.copy(
                        menu = null
                    )
            }
        }
    }

    ComponentPreviewContainer(Modifier.fillMaxSize()) {
        MainPane(notebook, context, processor)
    }
}