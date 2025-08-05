package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kr.lul.stringnotebook.state.organism.notebook.NewNotebookHeaderButton
import kr.lul.stringnotebook.ui.organism.notebook.ListHeaderButton
import kotlin.uuid.ExperimentalUuidApi

/**
 * - 디자인 : [ListHeader](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-23)
 */
@Composable
@ExperimentalUuidApi
fun ListHeader() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        ListHeaderButton(NewNotebookHeaderButton)
    }
}