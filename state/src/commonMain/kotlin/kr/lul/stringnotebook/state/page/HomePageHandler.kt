package kr.lul.stringnotebook.state.page

import kr.lul.stringnotebook.state.template.NotebookListHandler
import kotlin.uuid.ExperimentalUuidApi

/**
 * 홈 화면 핸들러.
 */
@ExperimentalUuidApi
interface HomePageHandler {
    object NoOp : HomePageHandler {
        override val list: NotebookListHandler = NotebookListHandler.NoOp
    }

    /**
     * 노트북 목록 핸들러.
     */
    val list: NotebookListHandler
}