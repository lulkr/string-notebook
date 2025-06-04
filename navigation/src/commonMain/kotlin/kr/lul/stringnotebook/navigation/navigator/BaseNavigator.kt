package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import kr.lul.logger.Logger

@Immutable
class BaseNavigator(
    val navController: NavHostController,
    /**
     * [androidx.navigation.compose.NavHost]의 `startDestination` 화면 정보.
     */
    override val destination: Destination
) : Navigator {
    private val logger = Logger("BaseNavigator")

    override fun back() {
        logger.d("#back called")

        navController.popBackStack()
    }

    override fun toString() = listOf(
        "navController=$navController"
    ).joinToString(", ", "BaseNavigator(", ")")
}