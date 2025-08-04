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
    val route: String

    /**
     * [route]의 인자.
     *
     * @see route
     */
    val arguments: List<NamedNavArgument>

    /**
     * 이 화면으로 이동할 때 사용할 수 있는 딥 링크.
     */
    val deepLinks: List<NavDeepLink>

    /**
     * 이 화면으로 이동할 수 있는 경로를 반환한다.
     *
     * @param args [route]의 인자에 대응하는 값.
     */
    fun route(vararg args: Any?): String
}