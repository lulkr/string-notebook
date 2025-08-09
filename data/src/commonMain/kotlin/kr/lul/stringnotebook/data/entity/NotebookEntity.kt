package kr.lul.stringnotebook.data.entity

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
internal class NotebookEntity(
    override val id: Uuid = Uuid.random(),
    override val name: String = DEFAULT_NAME,
    override val description: String? = null
) : Notebook {
    companion object {
        const val DEFAULT_NAME = "New Notebook"
    }

    private val logger = Logger("NotebookEntity@$id")

    override fun toString() = listOf(
        "id=$id"
    ).joinToString(", ", "NotebookEntity(", ")")
}