package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Offset
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 컨텍스트 메뉴.
 */
@ExperimentalUuidApi
@Immutable
class MenuState(
    /**
     * 표시 위치(DP 단위).
     */
    val position: Offset,
    /**
     * 메뉴 항목.
     */
    val items: List<MenuItemState>,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State {
    override val summary = "MenuState(position=$position, items=${items.map { it.summary }})"

    override fun equals(other: Any?) = this === other || (
            other is MenuState &&
                    position == other.position &&
                    items == other.items &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = position.hashCode()
        result = 31 * result + items.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "position=$position",
        "items=$items",
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "MenuState(", ")")
}