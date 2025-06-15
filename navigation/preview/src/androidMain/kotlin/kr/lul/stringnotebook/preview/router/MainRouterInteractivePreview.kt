package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.navigator.MainNavigator
import kr.lul.stringnotebook.navigation.router.MainRouter
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

/**
 * 메인 라우터의 인터랙티브 프리뷰 컴포넌트
 *
 * @see InteractivePreviewContainer
 * @see MainRouter
 */
@Composable
@OptIn(ExperimentalUuidApi::class)
@Preview
fun MainRouterInteractivePreview() {
    InteractivePreviewContainer(destination = MainNavigator, navigator = ::MainNavigator) {
        MainRouter(it)
    }
}