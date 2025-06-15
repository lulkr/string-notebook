package kr.lul.stringnotebook.preview.router

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.navigator.Navigator
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme
import org.koin.core.context.startKoin
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
fun <N : Navigator> InteractivePreviewContainer(
    baseNavigator: BaseNavigator = rememberBaseNavigator(MainNavigator),
    navigater: (BaseNavigator) -> N,
    router: @Composable (N) -> Unit
) {
    startKoin {
        modules(navigationModule)
    }

    StringNotebookTheme {
        Scaffold { padding ->
            NavHost(
                navController = baseNavigator.navController,
                startDestination = baseNavigator.destination.routePattern,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                composable(navigater(baseNavigator)) { navigator, _ ->
                    router(navigator)
                }
            }
        }
    }
}