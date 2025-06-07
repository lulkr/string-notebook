package kr.lul.stringnotebook.model

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 앱 설치 정보.
 */
@OptIn(ExperimentalUuidApi::class)
interface Install {
    /**
     * 앱 설치 ID.
     *
     * 설치 혹은 앱 데이터 삭제 후 처음 실행할 때 결정되는 임의의 값. `BEEFCAFE-4096-0001-0002-############` 형식.
     *
     * @see kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_INSTALL
     */
    val id: Uuid

    /**
     * 설치한 앱의 빌드 정보.
     */
    val build: Build
        get() = Build
}