package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.organism.MenuItemState
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun MenuItem(state: MenuItemState) {
    logger.v("#MenuItem args : state=$state")

    DropdownMenuItem(
        text = {
            Text(state.label)
        },
        onClick = state.onClick
    )
}