package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 앵커를 추가한다.
 *
 * @property x 앵커의 X 좌표.
 * @property y 앵커의 Y 좌표.
 */
@ExperimentalUuidApi
data class AddAnchorEvent(
    val x: Float = 0F,
    val y: Float = 0F
) : Event {
    override val id: Uuid = Uuid.random()

    override fun toString() = "AddAnchorEvent(id=$id, x=$x, y=$y)"
}
