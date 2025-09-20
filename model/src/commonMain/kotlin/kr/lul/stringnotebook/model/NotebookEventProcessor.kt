package kr.lul.stringnotebook.model

import kr.lul.logger.Logger
import kr.lul.stringnotebook.data.entity.Anchor
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.notebook.Notebook
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
            is AddAnchorEvent -> notebook.add(
                Anchor(type = event.type, x = event.x, y = event.y)
            )

            else -> error("Unsupported event type : event::class=${event::class}")
        }
    }
}