package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable

/**
 * 메인 페이지 상태.
 *
 * @property welcome 환영 메시지
 */
@Immutable
data class MainPageState(
    /**
     * 환영 메시지.
     */
    val welcome: String
)
