package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kr.lul.stringnotebook.state.organism.NewNotebookHeaderButton
import kr.lul.stringnotebook.state.template.NotebookListHandler
import kr.lul.stringnotebook.ui.organism.ListHeaderButton
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 목록의 헤더.
 *
 * 목록에 없는 노트북을 사용할 수 있는 도구를 제공한다.
 *
 * - 디자인 : [ListHeader](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-23)
 */
@Composable
@ExperimentalUuidApi
fun ListHeader(handler: NotebookListHandler = NotebookListHandler.NoOp) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        ListHeaderButton(NewNotebookHeaderButton, handler.new)
    }
}