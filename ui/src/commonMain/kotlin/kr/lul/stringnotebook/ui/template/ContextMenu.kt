package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.MenuState
import kr.lul.stringnotebook.ui.molecule.Text
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
@Composable
fun ContextMenu(
    state: MenuState
) {
    DropdownMenu(
        expanded = true,
        onDismissRequest = {},
        modifier = Modifier
            .offset(
                x = state.position.x.dp,
                y = state.position.y.dp
            )
            .padding(16.dp)
    ) {
        for (item in state.items) {
            Text(item.label)
        }
    }
}