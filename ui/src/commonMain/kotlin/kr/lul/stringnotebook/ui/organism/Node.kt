package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.ActivateEvent
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

    if (state != context.active) {
        LocalFocusManager.current
            .clearFocus()
    }

    OutlinedTextField(
        value = state.text,
        onValueChange = { },
        modifier = Modifier
            .clickable(!context.lock && state != context.active) {
                logger.d("#Node.onClick args : state=$state, context=$context")
                processor(ActivateEvent(state.id))
            }
            .onFocusChanged { focus ->
                if (!context.lock) {
                    when {
                        focus.isFocused && state != context.active -> {
                            logger.d("#Node.onFocusChanged : focus=$focus")
                            processor(ActivateEvent(state.id))
                        }
                    }
                }
            }
            .background(if (state == context.active) colors.background else colors.inactiveBackground)
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