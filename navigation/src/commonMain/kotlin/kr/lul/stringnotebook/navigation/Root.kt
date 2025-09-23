package kr.lul.stringnotebook.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.HomeNavigator
import kr.lul.stringnotebook.navigation.navigator.NotebookNavigator
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import kr.lul.stringnotebook.navigation.router.HomeRouter
import kr.lul.stringnotebook.navigation.router.NotebookRouter
import kr.lul.stringnotebook.navigation.router.SplashRouter
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun Root(
    baseNavigator: BaseNavigator
) {
    Root(baseNavigator) {
        composable(SplashNavigator(baseNavigator)) { navigator, _ ->
            SplashRouter(navigator)
        }

        // ------------------------------------------------------------------------------------------------------------

        composable(HomeNavigator(baseNavigator)) { navigator, _ ->
            HomeRouter(navigator)
        }

        composable(NotebookNavigator(baseNavigator)) { navigator, entry ->
            NotebookRouter(navigator)
        }
    }
}

@Composable
fun Root(baseNavigator: BaseNavigator, builder: NavGraphBuilder.() -> Unit) {
    logger.v("#Root args : baseNavigator=$baseNavigator, builder=$builder")

    StringNotebookTheme {
        Scaffold { padding ->
            NavHost(
                navController = baseNavigator.navController,
                startDestination = baseNavigator.destination.route,
                modifier = Modifier.fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding),
                builder = builder
            )
        }
    }
}