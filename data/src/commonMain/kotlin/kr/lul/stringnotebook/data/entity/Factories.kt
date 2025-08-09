package kr.lul.stringnotebook.data.entity

import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
fun Notebook(
    id: Uuid = Uuid.random(),
    name: String = NotebookEntity.DEFAULT_NAME,
    description: String? = null
): Notebook = NotebookEntity(id, name, description)