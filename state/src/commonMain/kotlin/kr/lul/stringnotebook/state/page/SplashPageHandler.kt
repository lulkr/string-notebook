package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable

/**
 * 스플래시 화면 핸들러.
 */
interface SplashPageHandler {
    @Immutable
    object NoOp : SplashPageHandler
}
