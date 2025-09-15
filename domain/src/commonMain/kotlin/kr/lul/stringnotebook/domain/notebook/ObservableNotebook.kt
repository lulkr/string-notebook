package kr.lul.stringnotebook.domain.notebook

import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Anchor
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 변경 사항을 감지하는 노트북 래퍼.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class ObservableNotebook(
    /**
     * 관찰할 노트북.
     */
    val notebook: Notebook
) : Notebook {
    protected val logger = Logger("ObservableNotebook@${notebook.id}")

    override val id: Uuid = notebook.id
    override var name: String
        get() = notebook.name
        set(value) {
            notebook.name = value
            afterChange()
        }
    override var memo: String?
        get() = notebook.memo
        set(value) {
            notebook.memo = value
            afterChange()
        }
    override val notes: List<Note>
        get() = super.notes
    override val anchors: List<Anchor>
        get() = notebook.anchors.mapNotNull { anchor ->
            observableAnchors[anchor.id].also { observable ->
                if (null == observable) {
                    logger.w("#anchors there is no observable anchor : anchor.id=${anchor.id}")
                }
            }
        }
    override val anchorContainerBorder: Border
        get() = notebook.anchorContainerBorder
    override val createdAt: Instant
        get() = notebook.createdAt
    override val updatedAt: Instant
        get() = notebook.updatedAt

    val summary: String
        get() = "ObservableNotebook(${notebook.id}, ${notebook.name})"

    protected val observableAnchors = mutableMapOf<Uuid, ObservableAnchor>()

    init {
        for (anchor in notebook.anchors) {
            observableAnchors[anchor.id] = anchor as? ObservableAnchor
                ?: object : ObservableAnchor(anchor) {
                    override fun afterChange() {
                        logger.d("#afterChange called.")
                    }
                }
        }
    }

    /**
     * 노트북 변경 전 콜백. [notebook] 변경 전에 호출한다.
     */
    open fun beforeChange() {}

    /**
     * [notebook] 변경 후 호출한다.
     */
    abstract fun afterChange()

    override fun add(anchor: Anchor): Boolean {
        logger.d("#add args : anchor=$anchor")

        beforeChange()
        val result = notebook.add(anchor)
        if (result) {
            observableAnchors[anchor.id] = anchor as? ObservableAnchor
                ?: object : ObservableAnchor(anchor) {
                    override fun afterChange() {
                        logger.d("#afterChange called.")
                    }
                }
            afterChange()
        }
        return result
    }

    override fun equals(other: Any?) = notebook.equals(other)

    override fun hashCode() = notebook.hashCode()

    override fun toString() = "ObservableNotebook(notebook=$notebook)"
}