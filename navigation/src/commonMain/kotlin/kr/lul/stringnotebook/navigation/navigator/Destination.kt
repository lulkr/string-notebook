package kr.lul.stringnotebook.navigation.navigator

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

/**
 * 내비게이션 백스택의 엔트리로 사용할 수 있는 화면을 추상화 한 인터페이스.
 */
interface Destination<N : Navigator> {
    /**
     * 화면 경로의 패턴.
     */
    val routePattern: String

    /**
     * [routePattern]의 인자.
     *
     * @see routePattern
     */
    val arguments: List<NamedNavArgument>

    /**
     * 이 화면으로 이동할 때 사용할 수 있는 딥 링크.
     */
    val deepLinks: List<NavDeepLink>

    /**
     * 이 화면을 사용하기 위한 [Navigator] 인스턴스를 반환한다.
     *
     * @param baseNavigator [BaseNavigator] 인스턴스
     */
    fun navigator(baseNavigator: BaseNavigator): N

    /**
     * 이 화면으로 이동할 수 있는 경로를 반환한다.
     *
     * @param args [routePattern]의 인자에 대응하는 값.
     */
    fun route(vararg args: Any?): String
}