package kr.lul.stringnotebook.state.template

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.organism.ObjectState

/**
 * 컨텍스트 메뉴 상태.
 *
 * @property x 메뉴 표시할 x 위치.
 * @property y 메뉴 표시할 y 위치.
 * @property target 메뉴가 대상으로 하는 객체. null일 경우 메뉴가 표시되지 않음.
 */
@Immutable
data class MenuState(
    val x: Float,
    val y: Float,
    val target: ObjectState? = null
)