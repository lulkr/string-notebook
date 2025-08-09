package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트 툴바.
 *
 * 노트북에 노트를 추가하거나 수정하는 도구모음.
 *
 * @param state 노트북 상태.
 */
@Composable
@ExperimentalUuidApi
fun NoteToolBar(state: NotebookState) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("노트 툴바")
    }
}