package kr.lul.stringnotebook.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import kr.lul.stringnotebook.navigation.router.MainRouter
import kr.lul.stringnotebook.navigation.router.SplashRouter
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Root(
    baseNavigator: BaseNavigator
) {
    logger.v("#Root args : baseNavigator=$baseNavigator")

    StringNotebookTheme {
        Scaffold { padding ->
            NavHost(
                navController = baseNavigator.navController,
                startDestination = baseNavigator.destination.route,
                modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding)
            ) {
                composable(SplashNavigator(baseNavigator)) { navigator, _ ->
                    SplashRouter(navigator)
                }

                // ------------------------------------------------------------------------------------------------------------

                composable(MainNavigator(baseNavigator)) { navigator, _ ->
                    MainRouter(navigator)
                }
            }
        }
    }
}
