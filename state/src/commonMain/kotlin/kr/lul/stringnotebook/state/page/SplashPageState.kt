package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable

/**
 * 스플래시 화면 상태.
 */
@Immutable
sealed interface SplashPageState {
    /**
     * 스플래시 화면 초기 상태.
     */
    @Immutable
    data object Init : SplashPageState

    /**
     * 스플래시 화면 진행 중 상태.
     *
     * 앱 실행 프로세스가 초기화를 진행중일 때.
     */
    @Immutable
    data object InProgress : SplashPageState

    /**
     * 스플래시 화면 성공 상태.
     *
     * 앱 실행 프로세스가 초기화를 완료했을 때.
     */
    @Immutable
    data object Success : SplashPageState

    /**
     * 스플래시 화면 실패 상태.
     *
     * 앱 실행 프로세스가 초기화 중 오류가 발생해서 정상적으로 앱을 실행할 수 없을 때.
     *
     * @param cause 원인.
     */
    @Immutable
    data class Fail(
        val cause: Throwable
    ) : SplashPageState
}
