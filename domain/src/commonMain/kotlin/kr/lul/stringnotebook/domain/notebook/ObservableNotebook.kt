package kr.lul.stringnotebook.domain.notebook

import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.Note
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 변경 사항을 감지하는 노트북 래퍼.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
open class ObservableNotebook(
    /**
     * 관찰할 노트북.
     */
    val notebook: Notebook,
    /**
     * 노트북 변경 콜백. [notebook] 변경 후 호출한다.
     */
    val afterChange: Notebook.() -> Unit
) : Notebook {
    private val logger = Logger("ObservableNotebook@${notebook.id}")

    override val id: Uuid = notebook.id
    override var name: String
        get() = notebook.name
        set(value) {
            notebook.name = value
            afterChange(notebook)
        }
    override var memo: String?
        get() = notebook.memo
        set(value) {
            notebook.memo = value
            afterChange(notebook)
        }
    override val notes: List<Note>
        get() = super.notes
    override val anchors: List<Anchor>
        get() = notebook.anchors
    override val createdAt: Instant
        get() = notebook.createdAt
    override val updatedAt: Instant
        get() = notebook.updatedAt

    val summary: String
        get() = "ObservableNotebook(${notebook.id}, ${notebook.name})"

    init {
        for (anchor in notebook.anchors) {

        }
    }

    /**
     * 노트북 변경 전 콜백. [notebook] 변경 전에 호출한다.
     */
    open fun beforeChange() {}

    override fun add(anchor: Anchor): Boolean {
        logger.d("#add args : anchor=$anchor")

        beforeChange()
        val result = notebook.add(anchor)
        if (result) {
            afterChange(notebook)
        }
        return result
    }

    override fun equals(other: Any?) = notebook.equals(other)

    override fun hashCode() = notebook.hashCode()

    override fun toString() = "ObservableNotebook(notebook=$notebook)"
}