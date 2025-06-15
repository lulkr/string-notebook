package kr.lul.stringnotebook.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.Destination
import kr.lul.stringnotebook.navigation.navigator.Navigator

/**
 * [BaseNavigator]를 생성, 재사용하는 컴포저블 함수.
 *
 * @param startDestination 시작 화면의 [Destination].
 * @param navController [NavHostController] 인스턴스.
 * @return [BaseNavigator] 인스턴스.
 */
@Composable
fun rememberBaseNavigator(
    startDestination: Destination<out Navigator>,
    navController: NavHostController = rememberNavController()
): BaseNavigator {
    val baseNavigator = remember(navController) {
        BaseNavigator(navController, startDestination)
    }

    return baseNavigator
}