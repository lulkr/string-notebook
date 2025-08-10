package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun PropertyEditor() {
    val scroll = rememberScrollState()

    Box(
        Modifier.background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(32.dp)
            .width(400.dp)
            .fillMaxHeight()
    ) {
        Column(
            Modifier.fillMaxSize()
                .verticalScroll(scroll)
        ) {
            Text(
                text = "속성 편집기",
                modifier = Modifier.pointerInput(Unit) {
                    detectTapGestures(
                        onTap = { offset ->
                            logger.d("#PropertyEditor.Text.onTap 노트북 클릭 대상에서 제외.")
                        }
                    )
                }
            )
        }
    }
}