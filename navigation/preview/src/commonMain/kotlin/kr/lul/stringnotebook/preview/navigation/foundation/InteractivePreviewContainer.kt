package kr.lul.stringnotebook.preview.navigation.foundation

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.composable
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.AbstractNavigator
import kr.lul.stringnotebook.navigation.navigator.Destination
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
inline fun <reified N : AbstractNavigator> InteractivePreviewContainer(
    navigator: N,
    crossinline router: @Composable (N) -> Unit
) {
    startKoin {
        modules(navigationModule)
    }

    Root(navigator.base) {
        composable(navigator) { nav, _ ->
            router(nav)
        }
    }
}