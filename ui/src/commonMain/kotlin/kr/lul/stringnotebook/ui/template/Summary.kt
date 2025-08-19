package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 요약정보.
 *
 * 노트북의 요약 정보를 표시한다.
 */
@Composable
@ExperimentalUuidApi
fun Summary(state: NotebookState, modifier: Modifier = Modifier) {
    Column(
        modifier.background(MaterialTheme.colorScheme.surfaceContainer, RoundedCornerShape(16.dp))
            .padding(32.dp, 16.dp)
    ) {
        Text(
            text = state.name,
            modifier = Modifier.pointerInput(state) {
                detectTapGestures(
                    onTap = { offset ->
                        logger.d("#Summary.Text.onTap 노트북 클릭 대상에서 제외.")
                    }
                )
            }
        )
    }
}