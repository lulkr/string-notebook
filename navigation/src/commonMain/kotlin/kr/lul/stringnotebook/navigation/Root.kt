package kr.lul.stringnotebook.navigation

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import kr.lul.stringnotebook.navigation.router.MainRouter
import kr.lul.stringnotebook.navigation.router.SplashRouter
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun Root(
    baseNavigator: BaseNavigator
) {
    logger.v("#Root args : baseNavigator=$baseNavigator")

    RootLayout(baseNavigator) {
        composable(SplashNavigator(baseNavigator)) { navigator, _ ->
            SplashRouter(navigator)
        }

        // ------------------------------------------------------------------------------------------------------------

        composable(MainNavigator(baseNavigator)) { navigator, _ ->
            MainRouter(navigator)
        }
    }
}
