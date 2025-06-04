package kr.lul.stringnotebook.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.Destination

@Composable
fun rememberBaseNavigator(
    startDestination: Destination,
    navController: NavHostController = rememberNavController()
): BaseNavigator {
    val baseNavigator = remember(navController) {
        BaseNavigator(navController, startDestination)
    }

    return baseNavigator
}