package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * @see kr.lul.stringnotebook.preview.ui.organism.NodePreview
 */
@Composable
@ExperimentalUuidApi
fun Node(
    state: NodeState,
    context: NotebookContext = NotebookContext.NoOp,
    processor: EventProcessor = EventProcessor.NoOp
) {
    logger.v("#Node args : state=$state, context=$context, processor=$processor")

    Text(
        text = state.text,
        modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}