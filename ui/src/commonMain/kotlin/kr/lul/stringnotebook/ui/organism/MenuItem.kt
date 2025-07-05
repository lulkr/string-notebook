package kr.lul.stringnotebook.ui.organism

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.MenuItemState
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun MenuItem(state: MenuItemState, context: Context, processor: EventProcessor) {
    logger.v("#MenuItem args : state=$state, context=$context, processor=$processor")

    DropdownMenuItem(
        text = {
            Text(text = state.label)
        },
        onClick = state.action
    )
}