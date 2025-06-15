package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.template.MenuState
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun ContextMenu(
    state: MenuState,
    context: NotebookContext,
    processor: EventProcessor,
    onDismissRequest: () -> Unit = {}
) {
    logger.v("#ContextMenu args : state=$state, context=$context, processor=$processor")

    Box(Modifier.offset(x = state.x.dp, y = state.y.dp)) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = onDismissRequest
        ) {
            if (null == state.target) {
                DropdownMenuItem(
                    text = { Text("Add Anchor") },
                    onClick = {
                    }
                )
            }
        }
    }
}