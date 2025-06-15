package kr.lul.stringnotebook.domain.foundation

import kr.lul.logger.Logger

/**
 * 이벤트 처리 인터페이스.
 */
interface EventProcessor {
    object NoOp : EventProcessor {
        private val logger = Logger("EventProcessor.NoOp")

        override fun invoke(event: Event) {
            logger.d("#invoke args : event=$event")
        }
    }

    /**
     * 이벤트를 처리한다.
     */
    operator fun invoke(event: Event)
}