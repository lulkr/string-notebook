package kr.lul.stringnotebook.data.entity

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.notebook.Border
import kr.lul.stringnotebook.domain.notebook.Notebook
import kr.lul.stringnotebook.domain.property.ColorProperty
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
internal class NotebookEntity(
    override val id: Uuid = Uuid.random(),
    override var name: String = DEFAULT_NAME,
    override var memo: String? = null,
    override val anchorContainerBorder: Border? = null,
    override val anchorContainerBackground: ColorProperty? = null,
    override val anchorContainerPadding: Float? = null,
    override val anchorRadius: Float? = null,
    override val anchorColor: ColorProperty? = null,
    override val createdAt: Instant = Clock.System.now()
) : Notebook {
    companion object {
        const val DEFAULT_NAME = "New Notebook"
    }

    private val logger = Logger("NotebookEntity@$id")

    private val _anchors: MutableList<Anchor> = mutableListOf()
    override val anchors: List<Anchor> = _anchors

    override var updatedAt: Instant = createdAt
        private set

    override fun add(anchor: Anchor): Boolean {
        logger.d("#add args : anchor=$anchor")

        val result: Boolean
        if (anchors.none { it.id == anchor.id }) {
            result = _anchors.add(anchor)
            updatedAt = Clock.System.now()
        } else {
            result = false
        }

        logger.d("#add return : $result")
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "memo=$memo",
        "anchors=$anchors",
        "anchorContainerBorder=${anchorContainerBorder?.summary}",
        "anchorContainerBackground=$anchorContainerBackground",
        "anchorContainerPadding=$anchorContainerPadding",
        "anchorColor=$anchorColor",
        "anchorRadius=$anchorRadius",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt"
    ).joinToString(", ", "NotebookEntity(", ")")
}