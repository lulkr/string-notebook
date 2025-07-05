package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.event.AddNodeEvent
import kr.lul.stringnotebook.domain.event.HideContextMenuEvent
import kr.lul.stringnotebook.domain.event.MoveEvent
import kr.lul.stringnotebook.domain.event.ShowNotebookContextMenuEvent
import kr.lul.stringnotebook.domain.event.UpdateNodeTextEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class EventProcessorDelegator : EventProcessor {
    override fun invoke(event: Event) = when (event) {
        is ActivateEvent -> {}
        is AddAnchorEvent -> {}
        is AddNodeEvent -> {}
        is HideContextMenuEvent -> {}
        is MoveEvent -> {}
        is ShowNotebookContextMenuEvent -> {}
        is UpdateNodeTextEvent -> {}
        else ->
            throw IllegalArgumentException("unsupported event type: event::class=${event::class.qualifiedName}")
    }
}