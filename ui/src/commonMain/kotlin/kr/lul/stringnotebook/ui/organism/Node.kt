package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.ui.molecule.NodeDefaults
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

    val colors = NodeDefaults.colors()

    OutlinedTextField(
        value = state.text,
        onValueChange = { },
        modifier = Modifier.background(if (state == context.active) colors.background else colors.inactiveBackground)
            .padding(16.dp),
        readOnly = state != context.active,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colors.text,
            unfocusedTextColor = colors.inactiveText,
            focusedContainerColor = colors.inactiveText,
            unfocusedContainerColor = colors.inactiveBackground,
            focusedBorderColor = colors.border,
            unfocusedBorderColor = colors.inactiveBorder
        )
    )
}