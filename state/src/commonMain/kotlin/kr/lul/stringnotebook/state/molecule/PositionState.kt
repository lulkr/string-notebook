package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [kr.lul.stringnotebook.domain.property.PositionProperty]의 상태 홀더.
 */
@ExperimentalUuidApi
@Stable
class PositionState(
    /**
     * X 좌표.
     */
    x: Float = 0F,
    /**
     * Y 좌표.
     */
    y: Float = 0F,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State {
    var x: Float by mutableStateOf(x)
    var y: Float by mutableStateOf(y)

    override val summary = "($x, $y)"

    override fun equals(other: Any?) = this === other || (
            other is PositionState &&
                    key == other.key &&
                    testTag == other.testTag &&
                    x == other.x &&
                    y == other.y
            )

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + testTag.hashCode()
        result = 31 * result + x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString() = listOf(
        "x=$x",
        "y=$y",
        "key=$key",
        "testTag=$testTag"
    ).joinToString(", ", "PositionState(", ")")
}