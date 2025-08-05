package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.navigator.HomeNavigator
import kr.lul.stringnotebook.navigation.router.HomeRouter
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.uuid.ExperimentalUuidApi

/**
 * 메인 라우터의 인터랙티브 프리뷰 컴포넌트
 *
 * @see InteractivePreviewContainer
 * @see HomeRouter
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalUuidApi
@Preview
fun HomeRouterInteractivePreview() {
    InteractivePreviewContainer(destination = HomeNavigator) {
        HomeRouter(it)
    }
}