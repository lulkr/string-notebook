package kr.lul.stringnotebook.ui.organism.notebook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * WYSWYG 노트북 편집기.
 */
@Composable
@ExperimentalUuidApi
fun Notebook(state: NotebookState) {
    Box(
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        Alignment.Center
    ) {
        Column {
            Text("${state.id}", Modifier.padding(8.dp))
            Text(state.name, Modifier.padding(8.dp))
            state.description?.let { description ->
                Text(description, Modifier.padding(8.dp))
            }
        }
    }
}