package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable

interface SplashPageHandler {
    @Immutable
    object NoOp : SplashPageHandler
}
