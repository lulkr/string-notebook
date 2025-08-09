package kr.lul.stringnotebook.model

import kr.lul.logger.Logger
import kr.lul.stringnotebook.data.entity.Notebook
import kr.lul.stringnotebook.data.repository.NotebookRepository
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
class NotebookModelImpl(
    private val repository: NotebookRepository
) : NotebookModel {
    private val logger = Logger("NotebookModelImpl")
    /**
     * 새로운 노트북을 생성한다.
     *
     * @return 생성된 노트북 객체.
     */
    override suspend fun create(): Notebook {
        logger.d("#create called.")

        val notebook = repository.create(Notebook())

        logger.d("#return : $notebook")
        return notebook
    }

    override suspend fun read(id: Uuid): Notebook? {
        logger.d("#read args : id=$id")

        val notebook = repository.read(id)

        logger.d("#read return : $notebook")
        return notebook
    }
}