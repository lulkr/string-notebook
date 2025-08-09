package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 요약정보.
 *
 * 노트북의 요약 정보를 표시한다.
 */
@Composable
@ExperimentalUuidApi
fun Summary(state: NotebookState) {
    Column(
        Modifier.background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(state.name)
    }
}