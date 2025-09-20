package kr.lul.stringnotebook.model

import kr.lul.stringnotebook.domain.notebook.Notebook
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
interface NotebookModel {
    /**
     * 새로운 노트북을 생성한다.
     *
     * @return 생성된 노트북 객체.
     */
    suspend fun create(): Notebook

    /**
     * 노트북을 읽는다.
     *
     * @param id 읽을 노트북의 ID. [Notebook.id]
     *
     * @return 읽은 노트북. 존재하지 않으면 `null`을 반환한다.
     */
    suspend fun read(id: Uuid): Notebook?
}