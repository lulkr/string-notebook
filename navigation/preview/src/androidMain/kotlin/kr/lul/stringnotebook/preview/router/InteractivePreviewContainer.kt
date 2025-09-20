package kr.lul.stringnotebook.preview.router

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.Destination
import kr.lul.stringnotebook.navigation.navigator.Navigator
import org.koin.core.context.startKoin
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

/**
 * 네비게이션 프리뷰([org.jetbrains.compose.ui.tooling.preview.Preview])를 위한 컨테이너 컴포넌트
 *
 * @param destination 프리뷰를 보려는 화면의 [Destination].
 * @param navigator 네비게이터 생성 함수
 * @param router 라우터 컴포넌트
 */
@Composable
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun <N : Navigator> InteractivePreviewContainer(
    destination: Destination<N>,
    router: @Composable (N) -> Unit
) {
    startKoin {
        modules(navigationModule)
    }

    val baseNavigator = rememberBaseNavigator(destination)
    Root(baseNavigator)

    // TODO `router` 실행해서 프리뷰 실행.
}