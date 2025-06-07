package kr.lul.stringnotebook.state.template

import androidx.compose.runtime.Immutable

/**
 * @see WelcomeHandler
 */
@Immutable
data class WelcomeState(
    val message: String = "Welcome!"
)
