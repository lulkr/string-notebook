package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.molecule.TextState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 메뉴 아이템.
 */
@ExperimentalUuidApi
@Immutable
data class MenuItemState(
    /**
     * 화면에 표시할 라벨.
     */
    val label: TextState,
    /**
     * 클릭 시 수행할 액션.
     */
    val onClick: () -> Unit,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State {
    override val summary = "MenuItemState(${label.summary})"
}