package kr.lul.stringnotebook.data.entity

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
internal class NotebookEntity(
    override val id: Uuid = Uuid.random(),
    override val name: String = DEFAULT_NAME,
    override val description: String? = null,
    override val createdAt: Instant = Clock.System.now()
) : Notebook {
    companion object {
        const val DEFAULT_NAME = "New Notebook"
    }

    private val logger = Logger("NotebookEntity@$id")

    override val anchors: List<Anchor> = emptyList()

    override val updatedAt: Instant = createdAt

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "description=$description",
        "anchors=$anchors",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt"
    ).joinToString(", ", "NotebookEntity(", ")")
}