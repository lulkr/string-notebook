package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kotlin.uuid.ExperimentalUuidApi

/**
 * - 디자인 : [NotebookList](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-14)
 */
@Composable
@ExperimentalUuidApi
fun NotebookList() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ListHeader()
    }
}