package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PropertyEditor() {
    val scroll = rememberScrollState()
    Column(
        Modifier.background(MaterialTheme.colorScheme.surfaceContainer)
            .width(400.dp)
            .fillMaxHeight()
            .verticalScroll(scroll)
    ) {
        Text("속성 편집기")
    }
}