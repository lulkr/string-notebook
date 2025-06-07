package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.template.MainNotebookMenuState
import kr.lul.stringnotebook.state.template.WelcomeState

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
    val welcome: WelcomeState = WelcomeState(),

    /**
     * 작업할 노트북을 선택 영역.
     */
    val notebook: MainNotebookMenuState = MainNotebookMenuState()
)
