package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import kr.lul.logger.Logger
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Immutable
class SplashNavigator(
    private val base: BaseNavigator
) : Navigator by base {
    companion object : Destination<SplashNavigator> {
        override val route = "splash"
        override val arguments: List<NamedNavArgument> = emptyList()
        override val deepLinks: List<NavDeepLink> = emptyList()

        override fun route(vararg args: Any?) = if (args.isEmpty()) {
            route
        } else {
            throw IllegalArgumentException("SplashNavigator does not accept arguments")
        }
    }

    private val logger = Logger("SplashNavigator")

    override val destination = Companion

    /**
     * 홈 화면으로 이동하기.
     */
    fun home() {
        logger.d("#home called.")

        base.navController.navigate(HomeNavigator.route()) {
            popUpTo(base.navController.graph.id) {
                inclusive = true
            }
        }
    }

    override fun toString() = listOf(
        "base=$base"
    ).joinToString(", ", "SplashNavigator(", ")")
}