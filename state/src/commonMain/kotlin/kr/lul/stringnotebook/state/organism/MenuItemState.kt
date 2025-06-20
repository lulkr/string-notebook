package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable

/**
 * 메뉴 항목의 상태를 나타내는 데이터 클래스.
 *
 * @property label 메뉴 항목의 레이블.
 * @property action 메뉴 항목이 선택되었을 때 실행되는 액션.
 */
@Immutable
data class MenuItemState(
    val label: String,
    val action: () -> Unit = { },
)
