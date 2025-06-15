package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.ui.organism.Viewer
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 에디터.
 *
 * @see kr.lul.stringnotebook.preview.ui.organism.MainPanePreview
 */
@Composable
@ExperimentalUuidApi
fun MainPane(state: NotebookState, context: NotebookContext, processor: EventProcessor, modifier: Modifier = Modifier) {
    logger.v("#MainPane args : state=$state, context=$context, processor=$processor, modifier=$modifier")

    val targets = state.objects // TODO 뷰포트로 걸러내기.

    Box(modifier = modifier) {
        Viewer(targets, context, processor)
    }
}