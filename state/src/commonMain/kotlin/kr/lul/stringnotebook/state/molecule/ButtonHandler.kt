package kr.lul.stringnotebook.state.molecule

import kr.lul.logger.Logger

/**
 * 버튼 조작 핸들러.
 *
 * 사용 가능한 버튼 조작 방법을 정의합니다.
 */
interface ButtonHandler {
    object NoOp : ButtonHandler {
        private val logger = Logger("ButtonHandler.NoOp")

        override fun onClick() {
            logger.d("#onClick called.")
        }
    }

    /**
     * 클릭, 탭 등의 버튼 조작 이벤트를 처리합니다.
     */
    fun onClick()
}