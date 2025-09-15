package kr.lul.stringnotebook.data.repository

import kr.lul.stringnotebook.domain.notebook.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 저장소 인터페이스.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface NotebookRepository {
    /**
     * 새로운 노트북을 저장하고 저장된 노트북을 반환한다.
     *
     * @param notebook 아직 저장하지 않은 노트북.
     * @return 저장된 노트북. `notebook`과 동일한 객체임을 보장하지 않는다.
     *
     * @see kr.lul.stringnotebook.data.entity.Notebook
     */
    suspend fun create(notebook: Notebook): Notebook

    /**
     * 노트북을 ID로 조회한다.
     *
     * @param id 조회할 노트북의 ID. [Notebook.id]
     * @return 조회된 노트북. 존재하지 않으면 `null`을 반환한다.
     */
    suspend fun read(id: Uuid): Notebook?
}