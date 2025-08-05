package kr.lul.stringnotebook.state.page

import kr.lul.stringnotebook.state.template.notebook.NotebookListHandler
import kotlin.uuid.ExperimentalUuidApi

/**
 * 메인 페이지 핸들러.
 */
@ExperimentalUuidApi
interface MainPageHandler {
    object NoOp : MainPageHandler {
        override val list: NotebookListHandler = NotebookListHandler.NoOp
    }

    /**
     * 노트북 목록 핸들러.
     */
    val list: NotebookListHandler
}