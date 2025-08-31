package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.state.molecule.PositionState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [kr.lul.stringnotebook.domain.foundation.Anchor]의 UI 상태 홀더.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
@Stable
class AnchorState(
    override val id: Uuid,
    type: AnchorType,
    name: String?,
    memo: String?,
    position: PositionState,
    override val createdAt: Instant,
    updatedAt: Instant,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString(),
) : NoteState {
    var type: AnchorType by mutableStateOf(type)
    override var name: String? by mutableStateOf(name)
    override var memo: String? by mutableStateOf(memo)
    val position: PositionState by mutableStateOf(position)
    override val updatedAt: Instant by mutableStateOf(updatedAt)
    override val summary = "AnchorState($type, ${position.summary})"

    override fun equals(other: Any?) = this === other || (
            other is AnchorState &&
                    id == other.id &&
                    type == other.type &&
                    name == other.name &&
                    memo == other.memo &&
                    position == other.position &&
                    createdAt == other.createdAt &&
                    updatedAt == other.updatedAt &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + position.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "type=$type",
        "name=$name",
        "memo=$memo",
        "position=$position",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt",
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(prefix = "AnchorState(", postfix = ")")
}