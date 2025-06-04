package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kr.lul.logger.Logger

@Immutable
class MainNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination {
        override val routePattern = "Main"
        override val arguments: List<NamedNavArgument> = emptyList()
        override val deepLinks: List<NavDeepLink> = emptyList()
        override fun route(vararg args: Any?) = if (args.isEmpty()) {
            routePattern
        } else {
            throw IllegalArgumentException("MainNavigator does not accept arguments")
        }
    }

    private val logger = Logger("MainNavigator")

    override val destination = Companion

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "MainNavigator(", ")")
}