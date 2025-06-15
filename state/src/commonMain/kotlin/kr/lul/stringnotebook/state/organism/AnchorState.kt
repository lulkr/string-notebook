package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 다른 객체의 위치 지정에 사용할 수 있는 앵커.
 */
@Immutable
@OptIn(ExperimentalUuidApi::class)
data class AnchorState(
    override val id: Uuid = Uuid.random(),
    val x: Float = 0.0F,
    val y: Float = 0.0F,
    val z: Float = 0.0F
) : ObjectState {
    constructor(id: Uuid = Uuid.random(), x: Int = 0, y: Int = 0, z: Int = 0)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())

    constructor(id: Uuid = Uuid.random(), x: Long = 0L, y: Long = 0L, z: Long = 0L)
            : this(id, x.toFloat(), y.toFloat(), z.toFloat())
}