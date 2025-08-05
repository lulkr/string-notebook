package kr.lul.stringnotebook.ui.template.notebook

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kr.lul.stringnotebook.state.template.notebook.NotebookListHandler
import kr.lul.stringnotebook.ui.template.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * - 디자인 : [NotebookList](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-14)
 */
@Composable
@ExperimentalUuidApi
fun NotebookList(handler: NotebookListHandler = NotebookListHandler.NoOp) {
    logger.v("#NotebookList args : handler=$handler")

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ListHeader(handler)
    }
}