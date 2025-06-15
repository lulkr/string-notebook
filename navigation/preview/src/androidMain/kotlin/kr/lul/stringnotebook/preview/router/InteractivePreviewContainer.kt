package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.RootLayout
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.navigator.Navigator
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

    RootLayout(baseNavigator) {
        composable(navigater(baseNavigator)) { navigator, _ ->
            router(navigator)
        }
    }
}