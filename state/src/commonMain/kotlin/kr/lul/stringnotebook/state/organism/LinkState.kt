package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 두 오브젝트 사이의 링크.
 *
 * 오브젝트의 위치는 오브젝트가 보유한 기준 앵커의 위치를 사용한다.
 */
@ExperimentalUuidApi
@Stable
class LinkState(
    from: AnchorState,
    to: AnchorState
) : ObjectState {
    override val id: Uuid = Uuid.random()

    val from: AnchorState by mutableStateOf(from)
    val to: AnchorState by mutableStateOf(to)

    override fun equals(other: Any?) = this === other || (
            other is LinkState &&
                    id == other.id &&
                    from == other.from &&
                    to == other.to
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + from.hashCode()
        result = 31 * result + to.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "from=$from",
        "to=$to"
    ).joinToString(", ", "LinkState(", ")")
}