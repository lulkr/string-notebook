package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.RootLayout
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.BaseNavigator
import kr.lul.stringnotebook.navigation.navigator.Destination
import kr.lul.stringnotebook.navigation.navigator.Navigator
import org.koin.core.context.startKoin
import kotlin.uuid.ExperimentalUuidApi

/**
 * 네비게이션 프리뷰([org.jetbrains.compose.ui.tooling.preview.Preview])를 위한 컨테이너 컴포넌트
 *
 * @param destination 프리뷰를 보려는 화면의 [Destination].
 * @param navigator 네비게이터 생성 함수
 * @param router 라우터 컴포넌트
 */
@Composable
@OptIn(ExperimentalUuidApi::class)
fun <N : Navigator> InteractivePreviewContainer(
    destination: Destination,
    navigator: (BaseNavigator) -> N,
    router: @Composable (N) -> Unit
) {
    startKoin {
        modules(navigationModule)
    }

    val baseNavigator = rememberBaseNavigator(destination)
    RootLayout(baseNavigator) {
        composable(navigator(baseNavigator)) { navigator, _ ->
            router(navigator)
        }
    }
}