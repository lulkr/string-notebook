package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.event.AddNodeEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NotebookMenuContext
import kr.lul.stringnotebook.state.organism.ObjectMenuContext
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun ContextMenu(
    context: Context,
    processor: EventProcessor,
    onDismissRequest: () -> Unit
) {
    logger.v("#ContextMenu args : context=$context, processor=$processor")

    val (x, y) = when (context) {
        is NotebookMenuContext ->
            context.x to context.y

        is ObjectMenuContext ->
            context.x to context.y

        else -> {
            logger.w("#ContextMenu : Unsupported context type: ${context::class.simpleName}")
            return
        }
    }

    Box(Modifier.offset(x = x.dp, y = y.dp)) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = onDismissRequest,
        ) {
            if (context is ObjectMenuContext) {
                // TODO
            }

            if (context is NotebookMenuContext) {
                DropdownMenuItem(
                    text = { Text("Add Anchor") },
                    onClick = {
                        processor(AddAnchorEvent(x, y))
                    }
                )

                DropdownMenuItem(
                    text = { Text("Add Node") },
                    onClick = {
                        processor(AddNodeEvent(x, y))
                    }
                )
            }
        }
    }
}