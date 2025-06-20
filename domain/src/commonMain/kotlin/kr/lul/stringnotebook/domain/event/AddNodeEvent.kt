package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노드를 추가한다.
 *
 * @property x 노드의 X 좌표.
 * @property y 노드의 Y 좌표.
 */
@ExperimentalUuidApi
data class AddNodeEvent(
    val x: Float = 0F,
    val y: Float = 0F
) : Event {
    override val id: Uuid = Uuid.random()

    override fun toString() = "AddNodeEvent(id=$id, x=$x, y=$y)"
}
