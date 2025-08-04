package kr.lul.stringnotebook.shared

import androidx.compose.ui.window.ComposeUIViewController
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import platform.UIKit.UIViewController
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("unused", "FunctionName")
fun ComposeController(): UIViewController {
    return try {
        ComposeUIViewController {
            Root(rememberBaseNavigator(SplashNavigator))
        }
    } catch (e: Throwable) {
        println("error=$e\n${e.stackTraceToString()}")
        throw e
    }
}
