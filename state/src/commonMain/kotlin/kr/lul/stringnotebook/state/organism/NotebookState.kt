package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import kr.lul.stringnotebook.domain.notebook.Notebook
import kr.lul.stringnotebook.state.molecule.State
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [Notebook]를 나타내는 상태 홀더.
 */
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Stable
class NotebookState(
    /**
     * @see Notebook.id
     */
    val id: Uuid,
    /**
     * @see Notebook.name
     * @see NotebookState.name
     */
    name: String,
    /**
     * @see Notebook.memo
     * @see NotebookState.memo
     */
    memo: String?,
    /**
     * @see Notebook.anchors
     * @see NotebookState.anchors
     */
    anchors: List<AnchorState>,
    /**
     * @see Notebook.createdAt
     * @see NotebookState.createdAt
     */
    createdAt: Instant,
    /**
     * @see Notebook.updatedAt
     * @see NotebookState.updatedAt
     */
    updatedAt: Instant = createdAt,
    /**
     * @see NotebookState.menu
     */
    menu: MenuState? = null,
    /**
     * 화면상 표시 크기. DP 단위.
     *
     * @see NotebookState.size
     */
    size: Size = Size.Unspecified,
    anchorPropertiesDefault: AnchorProperties? = null,
    anchorPropertiesHovered: AnchorProperties? = null,
    anchorPropertiesSelected: AnchorProperties? = null,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State, EditContext {
    companion object {
        val Placeholder = NotebookState(
            id = Uuid.parse("00000000-0000-0000-0000-000000000000"),
            name = "플레이스홀더",
            memo = null,
            anchors = emptyList(),
            createdAt = Instant.fromEpochSeconds(0, 0),
            size = Size.Zero
        )
    }

    var name: String by mutableStateOf(name)
    var memo: String? by mutableStateOf(memo)

    override var anchors: List<AnchorState> by mutableStateOf(anchors)
    override val notes: List<NoteState>
        get() = anchors

    val createdAt: Instant by mutableStateOf(createdAt)
    var updatedAt: Instant by mutableStateOf(updatedAt)

    override var menu: MenuState? by mutableStateOf(menu)

    /**
     * 노트북의 화면상 표시 크기. DP 단위.
     */
    var size: Size by mutableStateOf(size)

    override val anchorPropertiesDefault: AnchorProperties? by mutableStateOf(anchorPropertiesDefault)
    override val anchorPropertiesHovered: AnchorProperties? by mutableStateOf(anchorPropertiesHovered)
    override val anchorPropertiesSelected: AnchorProperties? by mutableStateOf(anchorPropertiesSelected)

    override val summary: String
        get() = "NotebookState('$name', anchors=${anchors.map { it.summary }})"

    override fun equals(other: Any?) = this === other || (
            other is NotebookState &&
                    id == other.id &&
                    name == other.name &&
                    memo == other.memo &&
                    anchors == other.anchors &&
                    createdAt == other.createdAt &&
                    updatedAt == other.updatedAt &&
                    menu == other.menu &&
                    size == other.size &&
                    anchorPropertiesDefault == other.anchorPropertiesDefault &&
                    anchorPropertiesHovered == other.anchorPropertiesHovered &&
                    anchorPropertiesSelected == other.anchorPropertiesSelected &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + anchors.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        result = 31 * result + (menu?.hashCode() ?: 0)
        result = 31 * result + size.hashCode()
        result = 31 * result + (anchorPropertiesDefault?.hashCode() ?: 0)
        result = 31 * result + (anchorPropertiesHovered?.hashCode() ?: 0)
        result = 31 * result + (anchorPropertiesSelected?.hashCode() ?: 0)
        result = 31 * result + key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name='$name'",
        "memo=$memo",
        "anchors=${anchors.map { it.summary }}",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt",
        "menu=$menu",
        "size=$size",
        "anchorPropertiesDefault=$anchorPropertiesDefault",
        "anchorPropertiesHovered=$anchorPropertiesHovered",
        "anchorPropertiesSelected=$anchorPropertiesSelected",
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "NotebookState(", ")")
}
