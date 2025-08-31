package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.molecule.TextState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 메뉴 아이템.
 *
 * 메뉴 아이템이 담당하는 기능은 아이템 사이에 차이가 크기 때문에, 공통화 할 수 없어서 상태 콜백을 속성([onClick])을
 * 사용하고 별도의 핸들러를 사용하지 않는다.
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