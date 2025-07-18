package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NotebookFocusedContext
import kr.lul.stringnotebook.ui.molecule.AnchorPropertiesDefaults
import kotlin.uuid.ExperimentalUuidApi

/**
 * @see kr.lul.stringnotebook.preview.ui.organism.AnchorPreview
 */
@Composable
@ExperimentalUuidApi
fun Anchor(
    state: AnchorState,
    context: Context = NotebookFocusedContext(),
    processor: EventProcessor = EventProcessor.NoOp,
    properties: AnchorProperties = AnchorPropertiesDefaults.default()
) {
    logger.v("#Anchor args : state=$state, context=$context, processor=$processor, properties=$properties")

    Box(modifier = Modifier.background(properties.fill, CircleShape).padding(properties.radius))
}