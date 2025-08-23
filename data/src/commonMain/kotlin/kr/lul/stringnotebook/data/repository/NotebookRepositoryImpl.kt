package kr.lul.stringnotebook.data.repository

import kotlinx.coroutines.delay
import kr.lul.logger.Logger
import kr.lul.stringnotebook.data.entity.NotebookEntity
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
internal class NotebookRepositoryImpl : NotebookRepository {
    private val logger = Logger("NotebookRepositoryImpl")

    private val storage = mutableMapOf<Uuid, Notebook>()

    /**
     * 새로운 노트북을 저장하고 저장된 노트북을 반환한다.
     *
     * @param notebook 아직 저장하지 않은 노트북.
     * @return 저장된 노트북.
     */
    override suspend fun create(notebook: Notebook): Notebook {
        logger.d("#create args : notebook=$notebook")
        require(notebook is NotebookEntity) { "unsupported notebook type : notebook::class=${notebook::class.qualifiedName}" }

        delay(1_000) // TODO 실재 코드 작성하기. 로컬 혹은 리모트 저장.

        require(!storage.containsKey(notebook.id)) { "already exists notebook : notebook=$notebook" }
        storage[notebook.id] = notebook

        logger.d("#create return : $notebook")
        return notebook
    }

    override suspend fun read(id: Uuid): Notebook? {
        logger.d("#read args : id=$id")

        val notebook = storage[id]

        delay(2_000) // TODO 스토리지나 리모드에서 읽기 흉내내는 딜레이. 실제 코드로 변경 필요.

        logger.d("#read return : $notebook")
        return notebook
    }
}