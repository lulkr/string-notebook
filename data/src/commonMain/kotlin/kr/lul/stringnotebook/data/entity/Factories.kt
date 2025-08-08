package kr.lul.stringnotebook.data.entity

import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
fun Notebook(id: Uuid = Uuid.random()): Notebook = NotebookEntity(id)