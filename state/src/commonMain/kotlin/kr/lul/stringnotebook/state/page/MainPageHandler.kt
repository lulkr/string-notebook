package kr.lul.stringnotebook.state.page

import kr.lul.stringnotebook.state.template.MainNotebookMenuHandler
import kr.lul.stringnotebook.state.template.WelcomeHandler

/**
 * 메인 페이지의 핸들러.
 *
 * @see MainPageState
 */
interface MainPageHandler {
    object NoOp : MainPageHandler {
        override val welcome: WelcomeHandler = WelcomeHandler.NoOp
        override val notebook: MainNotebookMenuHandler = MainNotebookMenuHandler.NoOp
    }

    val welcome: WelcomeHandler
    val notebook: MainNotebookMenuHandler
}