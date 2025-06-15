package kr.lul.stringnotebook.navigation.navigator

/**
 * 어떤 화면에서 사용 가능한 화면 전환 기능을 정의한다.
 *
 * 내비게이션 백스택의 상태 변경에 필요한 도구를 제공한다.
 */
interface Navigator {
    /**
     * 현재 화면.
     */
    val destination: Destination<out Navigator>

    /**
     * 이전 화면으로 돌아가기.
     */
    fun back()
}