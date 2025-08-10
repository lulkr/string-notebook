package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ContextMenu(
    position: Offset,
    onDismissRequest: () -> Unit = {}
) {
    val density = LocalDensity.current
    Box(
        Modifier.offset(
            x = with(density) { position.x.toDp() },
            y = with(density) { position.y.toDp() }
        )) {
        DropdownMenu(
            expanded = true,
            onDismissRequest = onDismissRequest,
            modifier = Modifier.padding(16.dp)
        ) {
            Text("#ContextMenu 더미 메뉴")
        }
    }
}