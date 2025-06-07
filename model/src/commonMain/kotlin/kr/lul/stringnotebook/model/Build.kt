package kr.lul.stringnotebook.model

import kr.lul.stringnotebook.domain.foundation.Configuration
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 앱 빌드 정보.
 *
 * 애플리케이션을 빌드할 때 지정된다.
 */
@OptIn(ExperimentalStdlibApi::class, ExperimentalUuidApi::class)
data object Build {
    /**
     * 빌드 ID.
     *
     * `BEEFCAFE-4096-0001-0001-############` 형식.
     *
     * @see kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_BUILD
     */
    val id: Uuid = Configuration.ID_PREFIX_APP_BUILD.generateId(1)

    override fun toString() = listOf(
        "id=$id"
    ).joinToString(", ", "Build(", ")")
}