package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.router.MainRouter
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
@Preview
fun MainRouterInteractivePreview() {
    InteractivePreviewContainer(navigater = ::MainNavigator) {
        MainRouter(it)
    }
}