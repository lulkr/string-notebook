package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 객체 이동하기 이벤트.
 *
 * @property target 미리보기 중인 오브젝트의 ID
 * @property x 이동할 위치의 x 좌표
 * @property y 이동할 위치의 y 좌표
 */
@ExperimentalUuidApi
class MovePreviewEvent(
    val target: Uuid,
    val x: Float,
    val y: Float,
) : Event {
    override val id = Uuid.random()

    override fun equals(other: Any?) = this === other || (
            other is MovePreviewEvent &&
                    id == other.id &&
                    target == other.target &&
                    x == other.x &&
                    y == other.y
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + target.hashCode()
        result = 31 * result + x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "target=$target",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "MoveEvent(", ")")
}