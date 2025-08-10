package kr.lul.stringnotebook.state.template

import kr.lul.logger.Logger
import kr.lul.stringnotebook.state.molecule.ButtonHandler
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 목록 핸들러.
 */
@ExperimentalUuidApi
interface NotebookListHandler {
    object NoOp : NotebookListHandler {
        private val logger = Logger("NotebookListHandler.NoOp")

        override val new: ButtonHandler = ButtonHandler.NoOp

        override fun onClickOpen(id: Uuid) {
            logger.d("#onClickOpen args : id=$id")
        }
    }

    /**
     * 새 노트북 생성 버튼 핸들러.
     */
    val new: ButtonHandler

    /**
     * 저장된 노트북 열기.
     */
    fun onClickOpen(id: Uuid)
}