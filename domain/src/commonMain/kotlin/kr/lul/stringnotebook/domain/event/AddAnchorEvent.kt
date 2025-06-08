package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.anchor.StandardAnchorType
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class AddAnchorEvent(
    override val id: Uuid = Uuid.random(),
    val anchorType: AnchorType = StandardAnchorType.ABSOLUTE,
    val x: Int = 0,
    val y: Int = 0,
) : Event {
    override val type: EventType = StandardEventType.ADD_ANCHOR
}
