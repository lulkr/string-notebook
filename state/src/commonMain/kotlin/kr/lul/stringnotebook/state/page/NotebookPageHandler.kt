package kr.lul.stringnotebook.state.page

import kr.lul.logger.Logger

/**
 * 사용자의 노트북 조작 핸들러.
 *
 * @see NotebookPageState
 */
interface NotebookPageHandler {
    object NoOp : NotebookPageHandler {
        private val logger = Logger("NotebookPageHandler.NoOp")
    }
}