package kr.lul.stringnotebook.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(navigationModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "String Notebook",
    ) {
        Root(rememberBaseNavigator(SplashNavigator))
    }
}
