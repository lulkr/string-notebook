package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노드 상태 홀더.
 *
 * @property id 노드의 고유 식별자.
 * @property x 노드의 x 좌표.
 * @property y 노드의 y 좌표.
 * @property z 노드의 z 좌표.
 * @property text 노드의 텍스트 내용.
 */
@ExperimentalUuidApi
@Immutable
class NodeState(
    override val id: Uuid = Uuid.random(),
    val x: Float = 0.0F,
    val y: Float = 0.0F,
    val z: Float = 0.0F,
    val text: String = ""
) : ObjectState {
    constructor(id: Uuid = Uuid.random(), x: Int = 0, y: Int = 0, z: Int = 0, text: String = "")
            : this(id, x.toFloat(), y.toFloat(), z.toFloat(), text)

    constructor(id: Uuid = Uuid.random(), x: Long = 0L, y: Long = 0L, z: Long = 0L, text: String = "")
            : this(id, x.toFloat(), y.toFloat(), z.toFloat(), text)

    fun copy(
        x: Float = this.x,
        y: Float = this.y,
        z: Float = this.z,
        text: String = this.text
    ) = NodeState(
        id = this.id,
        x = x,
        y = y,
        z = z,
        text = text
    )

    override fun equals(other: Any?) = this === other || (
            other is NodeState &&
                    id == other.id &&
                    x == other.x &&
                    y == other.y &&
                    z == other.z &&
                    text == other.text
            )

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + id.hashCode()
        result = 31 * result + text.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "x=$x",
        "y=$y",
        "z=$z",
        "text='$text'"
    ).joinToString(", ", "NodeState(", ")")
}
