package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 다른 객체의 위치 지정에 사용할 수 있는 앵커.
 *
 * @property id 앵커의 고유 식별자.
 * @property x 앵커의 x 좌표.
 * @property y 앵커의 y 좌표.
 * @property z 앵커의 z 좌표.
 */
@ExperimentalUuidApi
@Stable
class AnchorState(
    override val id: Uuid = Uuid.random(),
    x: Float = 0.0F,
    y: Float = 0.0F,
    z: Float = 0.0F
) : ObjectState {
    var x: Float by mutableStateOf(x)
    var y: Float by mutableStateOf(y)
    var z: Float by mutableStateOf(z)

    constructor(id: Uuid = Uuid.random(), x: Int = 0, y: Int = 0, z: Int = 0)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())

    constructor(id: Uuid = Uuid.random(), x: Long = 0L, y: Long = 0L, z: Long = 0L)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())

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