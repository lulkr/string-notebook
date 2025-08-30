package kr.lul.stringnotebook.model

import kr.lul.logger.Logger
import kr.lul.stringnotebook.data.entity.AnchorEntity
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.domain.property.PositionProperty
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
class NotebookEventProcessor(
    val notebook: Notebook
) : EventProcessor {
    private val logger = Logger("NotebookEventProcessor@${notebook.id}")

    override fun invoke(event: Event) {
        logger.d("#invoke args : event=$event")

        when (event) {
            is AddAnchorEvent -> handle(event)
            else -> error("Unsupported event type : event::class=${event::class}")
        }
    }

    private fun handle(event: AddAnchorEvent) {
        val anchor = AnchorEntity(type = event.type, position = PositionProperty(x = event.x, y = event.y))

        notebook.add(anchor)
    }
}