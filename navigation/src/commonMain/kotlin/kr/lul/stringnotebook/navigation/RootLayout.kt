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
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.ui.atom.StringNotebookTheme

@Composable
fun RootLayout(
    baseNavigator: BaseNavigator,
    builder: NavGraphBuilder.() -> Unit
) {
    logger.v("#RootLayout args : baseNavigator=$baseNavigator, builder=$builder")

    StringNotebookTheme {
        Scaffold { padding ->
            NavHost(
                navController = baseNavigator.navController,
                startDestination = baseNavigator.destination.routePattern,
                modifier = Modifier.fillMaxSize()
                    .padding(padding)
                    .background(MaterialTheme.colorScheme.background),
                builder = builder
            )
        }
    }
}