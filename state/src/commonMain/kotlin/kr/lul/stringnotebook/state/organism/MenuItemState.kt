package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi

/**
 * 메뉴 항목의 상태를 나타내는 데이터 클래스.
 *
 * @property label 메뉴 항목의 레이블.
 * @property event 메뉴 항목이 선택되었을 때 실행되는 이벤트.
 */
@ExperimentalUuidApi
@Immutable
data class MenuItemState(
    val label: TextState,
    val event: Event
)
