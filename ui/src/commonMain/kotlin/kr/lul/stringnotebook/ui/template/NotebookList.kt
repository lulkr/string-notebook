package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kr.lul.stringnotebook.state.template.NotebookListHandler
import kotlin.uuid.ExperimentalUuidApi

/**
 * 홈 화면에서 작업할 노트북을 고를 수 있는 UI 컴포넌트.
 *
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