package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import kr.lul.stringnotebook.domain.event.DeactivateEvent
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.ShowNotebookContextMenuEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NotebookMenuContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectActivatedContext
import kr.lul.stringnotebook.state.organism.ObjectMenuContext
import kr.lul.stringnotebook.ui.organism.Viewer
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 에디터.
 *
 * @see kr.lul.stringnotebook.preview.ui.template.MainPanePreview
 */
@Composable
@ExperimentalUuidApi
fun MainPane(state: NotebookState, context: Context, processor: EventProcessor, modifier: Modifier = Modifier) {
    logger.v("#MainPane args : state=$state, context=$context, processor=$processor, modifier=$modifier")

    Box(
        modifier.pointerInput(state, context) {
            detectTapGestures { offset ->
                when (context) {
                    is NeutralContext ->
                        processor(ShowNotebookContextMenuEvent(x = offset.x.toDp().value, y = offset.y.toDp().value))

                    is ObjectActivatedContext ->
                        processor(DeactivateEvent())

                    else -> {}
                }
            }
        }
    ) {
        val objects = state.objects // TODO 뷰포트로 걸러내기.

        Viewer(objects, context, processor)

        if (context is NotebookMenuContext || context is ObjectMenuContext) {
            ContextMenu(
                context = context,
                processor = processor,
                onDismissRequest = { processor(HideContextMenuEvent()) }
            )
        }
    }
}