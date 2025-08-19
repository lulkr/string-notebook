package kr.lul.stringnotebook.state.organism

import kr.lul.logger.Logger

/**
 * 노트북 핸들러 인터페이스.
 */
interface NotebookHandler {
    object NoOp : NotebookHandler {
        private val logger = Logger("NotebookHandler.NoOp")

        override fun onClickBackground() {
            logger.d("#onClickBackground called.")
        }
    }

    /**
     * 바탕화면 클릭.
     */
    fun onClickBackground()
}