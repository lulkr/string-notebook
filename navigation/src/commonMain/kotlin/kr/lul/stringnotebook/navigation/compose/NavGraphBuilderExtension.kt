package kr.lul.stringnotebook.navigation.compose

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.lul.stringnotebook.navigation.navigator.Navigator
import kotlin.jvm.JvmSuppressWildcards

/**
 * [Navigator]를 사용하여 내비게이션 그래프에 컴포저블을 추가한다.
 *
 * @param navigator 내비게이터 인스턴스
 * @param enterTransition 진입 애니메이션
 * @param exitTransition 종료 애니메이션
 * @param popEnterTransition 뒤로 가기 시 진입 애니메이션
 * @param popExitTransition 뒤로 가기 시 종료 애니메이션
 * @param sizeTransform 크기 변환 애니메이션
 * @param content 컴포저블 콘텐츠
 */
inline fun <N : Navigator> NavGraphBuilder.composable(
    navigator: N,
    noinline enterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
    noinline exitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
    noinline popEnterTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = enterTransition,
    noinline popExitTransition: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = exitTransition,
    noinline sizeTransform: (@JvmSuppressWildcards AnimatedContentTransitionScope<NavBackStackEntry>.() -> SizeTransform?)? = null,
    noinline content: @Composable AnimatedContentScope.(N, NavBackStackEntry) -> Unit
) {
    val destination = navigator.destination
    composable(
        destination.routePattern,
        destination.arguments,
        destination.deepLinks,
        enterTransition,
        exitTransition,
        popEnterTransition,
        popExitTransition,
        sizeTransform
    ) {
        content(navigator, it)
    }
}