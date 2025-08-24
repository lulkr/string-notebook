package kr.lul.stringnotebook.state.organism

import androidx.compose.ui.geometry.Offset
import kr.lul.logger.Logger

/**
 * 노트북 핸들러 인터페이스.
 */
interface NotebookHandler {
    object NoOp : NotebookHandler {
        private val logger = Logger("NotebookHandler.NoOp")

        override fun onClick(offset: Offset) {
            logger.d("#onClick args : offset=$offset")
        }

        override fun onDoubleClick(offset: Offset) {
            logger.d("#onDoubleClick args : offset=$offset")
        }

        override fun onLongClick(offset: Offset) {
            logger.d("#onLongClick args : offset=$offset")
        }
    }

    /**
     * 노트북(바탕화면) 클릭.
     *
     * @param offset 클릭 좌표(DP 단위).
     */
    fun onClick(offset: Offset)

    /**
     * 노트북(바탕화면) 더블 클릭.
     *
     * @param offset 클릭 좌표(DP 단위).
     */
    fun onDoubleClick(offset: Offset)

    /**
     * 노트북(바탕화면) 길게 클릭.
     *
     * @param offset 클릭 좌표(DP 단위).
     */
    fun onLongClick(offset: Offset)
}