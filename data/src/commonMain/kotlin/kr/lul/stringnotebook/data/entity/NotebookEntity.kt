package kr.lul.stringnotebook.data.entity

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.foundation.Notebook
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
internal class NotebookEntity(
    override val id: Uuid = Uuid.random(),
    override val name: String = DEFAULT_NAME,
    override val memo: String? = null,
    override val createdAt: Instant = Clock.System.now()
) : Notebook, EventProcessor {
    companion object {
        const val DEFAULT_NAME = "New Notebook"
    }

    private val logger = Logger("NotebookEntity@$id")

    private val _anchors: MutableList<Anchor> = mutableListOf()
    override val anchors: List<Anchor> = _anchors

    override val updatedAt: Instant = createdAt

    override fun invoke(event: Event, callback: (Boolean) -> Unit) {
        logger.d("#invoke args : event=$event, callback=$callback")

        val result = when (event) {
            is AddAnchorEvent ->
                handle(event)

            else -> {
                logger.w("Unsupported event type : event=$event, event::class=${event::class}")
                false
            }
        }

        callback(result)
    }

    private fun handle(event: AddAnchorEvent): Boolean {
        // TODO 이벤트 처리.
        return true
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "description=$memo",
        "anchors=$anchors",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt"
    ).joinToString(", ", "NotebookEntity(", ")")
}