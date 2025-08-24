package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.MenuState
import kr.lul.stringnotebook.ui.molecule.Text
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Composable
fun ContextMenu(state: MenuState, onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    logger.v("#ContextMenu args : state=${state.summary}, modifier=$modifier")

    DropdownMenu(
        expanded = true,
        onDismissRequest = onDismissRequest,
        modifier = modifier.background(Color.White).padding(16.dp)
    ) {
        for (item in state.items) {
            Text(item.label)
        }
    }
}