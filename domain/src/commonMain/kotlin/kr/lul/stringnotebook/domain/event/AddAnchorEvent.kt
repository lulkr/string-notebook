package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class AddAnchorEvent(
    val x: Float = 0F,
    val y: Float = 0F
) : Event {
    override val id: Uuid = Uuid.random()

    override fun toString() = "AddAnchorEvent(id=$id, x=$x, y=$y)"
}
