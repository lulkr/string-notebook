package kr.lul.stringnotebook.ui.template

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.organism.MenuState
import kr.lul.stringnotebook.ui.molecule.Text
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북과 노트를 조작할 수 있는 메뉴.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
@Composable
fun ContextMenu(
    state: MenuState,
    onDismissRequest: () -> Unit
) {
    logger.v("#ContextMenu args : state=${state.summary}")

    DropdownMenu(
        expanded = true,
        onDismissRequest = onDismissRequest
    ) {
        for (item in state.items) {
            DropdownMenuItem(
                text = { Text(item.label) },
                onClick = item.onClick
            )
        }
    }
}