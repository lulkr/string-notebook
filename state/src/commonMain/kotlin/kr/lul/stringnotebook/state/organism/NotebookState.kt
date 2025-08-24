package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [Notebook]를 나타내는 상태 홀더.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
@Stable
class NotebookState(
    /**
     * @see Notebook.id
     */
    val id: Uuid,
    name: String,
    memo: String?,
    anchors: List<AnchorState>,
    override val menu: MenuState?,
    val createdAt: Instant,
    updatedAt: Instant,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State, EditContext {
    companion object {
        val Placeholder = NotebookState(
            Uuid.parse("00000000-0000-0000-0000-000000000000"),
            "플레이스홀더 노트북",
            null,
            emptyList(),
            null,
            Instant.fromEpochSeconds(0, 0),
            Instant.fromEpochSeconds(0, 0)
        )
    }

    var name: String by mutableStateOf(name)
    var memo: String? by mutableStateOf(memo)

    override var anchors: List<AnchorState> by mutableStateOf(anchors)
    override val notes: List<NoteState>
        get() = anchors

    var updatedAt: Instant by mutableStateOf(updatedAt)

    override val summary = "NotebookState($name, anchors=${anchors.size})"

    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id &&
                    name == other.name &&
                    memo == other.memo &&
                    anchors == other.anchors &&
                    menu == other.menu &&
                    createdAt == other.createdAt &&
                    updatedAt == other.updatedAt &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + anchors.hashCode()
        result = 31 * result + (menu?.hashCode() ?: 0)
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "memo=$memo",
        "anchors=$anchors",
        "menu=$menu",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt",
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "NotebookState(", ")")
}
