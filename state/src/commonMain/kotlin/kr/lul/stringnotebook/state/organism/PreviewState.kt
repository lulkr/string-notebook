package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 오브젝트의 미리보기 상태.
 *
 * @property x 미리보기의 x 좌표.
 * @property y 미리보기의 y 좌표.
 */
@ExperimentalUuidApi
@Stable
interface PreviewState : ObjectState {
    var x: Float
    var y: Float
}

@ExperimentalUuidApi
@Stable
class PreviewAnchorState(
    val anchor: AnchorState,
    x: Float,
    y: Float
) : PreviewState {
    override val id: Uuid = Uuid.random()
    override var x: Float by mutableStateOf(x)
    override var y: Float by mutableStateOf(y)

    init {
        require(null == anchor.preview) { "anchor already has a preview assigned : anchor=$anchor" }
        anchor.preview = this
    }

    override fun equals(other: Any?) = this === other || (
            other is PreviewAnchorState &&
                    id == other.id &&
                    anchor.id == other.anchor.id &&
                    x == other.x &&
                    y == other.y
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + anchor.id.hashCode()
        result = 31 * result + x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "anchor=${anchor.id}",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "PreviewAnchorState(", ")")
}