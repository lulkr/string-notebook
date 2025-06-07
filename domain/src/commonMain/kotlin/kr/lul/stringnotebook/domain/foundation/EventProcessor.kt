package kr.lul.stringnotebook.domain.foundation

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * 이벤트 처리기.
 */
interface EventProcessor {
    /**
     * 이벤트를 처리한다.
     *
     * @param event 처리할 이벤트
     * @param timestamp 이벤트 발생 시각, 기본값은 현재 시각
     */
    operator fun invoke(event: Event, timestamp: Instant = Clock.System.now())
}