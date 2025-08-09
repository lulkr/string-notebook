package kr.lul.stringnotebook.model

import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
interface NotebookModel {
    /**
     * 새로운 노트북을 생성한다.
     *
     * @return 생성된 노트북 객체.
     */
    suspend fun create(): Notebook
}