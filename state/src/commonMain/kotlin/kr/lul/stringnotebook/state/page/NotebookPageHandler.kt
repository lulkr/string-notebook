package kr.lul.stringnotebook.state.page

import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.organism.NotebookHandler
import kr.lul.stringnotebook.state.template.LayoutHandler

/**
 * 사용자의 노트북 조작 핸들러.
 *
 * @see NotebookPageState
 */
interface NotebookPageHandler {
    object NoOp : NotebookPageHandler {
        private val logger = Logger("NotebookPageHandler.NoOp")

        override val layout: LayoutHandler = LayoutHandler.NoOp

        override val notebook: NotebookHandler = NotebookHandler.NoOp
    }

    /**
     * 화면 레이아웃 핸들러.
     */
    val layout: LayoutHandler

    /**
     * 노트북 핸들러.
     */
    val notebook: NotebookHandler
}