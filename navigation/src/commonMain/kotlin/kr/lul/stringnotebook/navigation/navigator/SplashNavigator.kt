package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kr.lul.logger.Logger

@Immutable
class SplashNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination<SplashNavigator> {
        override val routePattern = "Splash"
        override val arguments: List<NamedNavArgument> = emptyList()
        override val deepLinks: List<NavDeepLink> = emptyList()

        override fun navigator(baseNavigator: BaseNavigator) = SplashNavigator(baseNavigator)

        override fun route(vararg args: Any?) = if (args.isEmpty()) {
            routePattern
        } else {
            throw IllegalArgumentException("SplashNavigator does not accept arguments")
        }
    }

    private val logger = Logger("SplashNavigator")

    override val destination = Companion

    fun main() {
        logger.d("#main called.")

        base.navController.navigate(MainNavigator.route()) {
            popUpTo(base.navController.graph.id) {
                inclusive = true
            }
        }
    }

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "SplashNavigator(", ")")
}