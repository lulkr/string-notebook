package kr.lul.stringnotebook.navigation.navigator

import androidx.compose.runtime.Immutable
import androidx.navigation.NavHostController
import kr.lul.logger.Logger

/**
 * 내비게이션에 필요한 기본 기능을 제공한다.
 *
 * @property navController [androidx.navigation.compose.NavHost]의 [NavHostController]
 * @property destination [androidx.navigation.compose.NavHost]의 `startDestination` 화면 정보
 */
@Immutable
class BaseNavigator(
    val navController: NavHostController,
    override val destination: Destination<out Navigator>
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