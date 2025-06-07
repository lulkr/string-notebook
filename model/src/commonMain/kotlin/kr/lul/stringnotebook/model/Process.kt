package kr.lul.stringnotebook.model

import kotlinx.datetime.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 앱 실행 정보.
 */
@OptIn(ExperimentalUuidApi::class)
interface Process {
    /**
     * 프로세스 ID.
     *
     * `BEEFCAFE-4096-0001-0003-############` 형식.
     *
     * @see kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_PROCESS
     */
    val id: Uuid

    /**
     * 프로세스 시작 시각.
     */
    val startedAt: Instant
}