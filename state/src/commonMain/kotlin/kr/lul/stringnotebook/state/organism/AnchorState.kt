package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 다른 객체의 위치 지정에 사용할 수 있는 앵커.
 */
@Immutable
@ExperimentalUuidApi
class AnchorState(
    override val id: Uuid = Uuid.random(),
    val x: Float = 0.0F,
    val y: Float = 0.0F,
    val z: Float = 0.0F
) : ObjectState {
    constructor(id: Uuid = Uuid.random(), x: Int = 0, y: Int = 0, z: Int = 0)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())

    constructor(id: Uuid = Uuid.random(), x: Long = 0L, y: Long = 0L, z: Long = 0L)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())

    fun copy(
        x: Float = this.x,
        y: Float = this.y,
        z: Float = this.z
    ) = AnchorState(id, x, y, z)

    override fun equals(other: Any?) = this === other || (
            other is AnchorState &&
                    id == other.id &&
                    x == other.x &&
                    y == other.y &&
                    z == other.z
            )

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + id.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "x=$x",
        "y=$y",
        "z=$z"
    ).joinToString(", ", "AnchorState(", ")")
}