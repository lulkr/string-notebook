package kr.lul.stringnotebook.data.repository

import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 저장소 인터페이스.
 */
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
}