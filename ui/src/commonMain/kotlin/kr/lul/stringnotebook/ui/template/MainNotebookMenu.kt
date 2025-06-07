package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.template.MainNotebookMenuHandler
import kr.lul.stringnotebook.state.template.MainNotebookMenuState
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun MainNotebookMenu(state: MainNotebookMenuState, handler: MainNotebookMenuHandler) {
    logger.v("#MainNotebookMenu args : state=$state, handler=$handler")

    Column {
        Row {
            Card(onClick = handler::onClickNewNotebook) {
                Text("➕", Modifier.padding(32.dp))
            }
        }
    }
}