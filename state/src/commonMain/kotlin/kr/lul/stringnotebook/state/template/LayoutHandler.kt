package kr.lul.stringnotebook.state.template

import kr.lul.logger.Logger

/**
 *
 *
 * @see LayoutState
 */
interface LayoutHandler {
    object NoOp : LayoutHandler {
        private val logger = Logger("LayoutHandler.NoOp")

        override fun onChangeLayout() {
            logger.d("onChangeLayout() called.")
        }
    }

    /**
     * 레이아웃 변경 이벤트 핸들러.
     */
    fun onChangeLayout()
}