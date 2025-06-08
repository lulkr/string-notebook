package kr.lul.stringnotebook.model

import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.foundation.StringNotebook

class EventProcessorImpl(
    private val notebook: StringNotebook
) : EventProcessor {
    override fun invoke(event: Event, timestamp: Instant) {
        TODO("Not yet implemented")
    }
}