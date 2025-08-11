package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_PROPERTY
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [Type]의 인스턴스.
 *
 * @param T 스트링노트 앱 내부에서 사용하는 타입.
 *
 * @see Type
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface Property<T> {
    companion object {
        const val NAME_PATTERN = "[a-z][a-zA-Z0-9_]*"
        val NAME_REGEX = NAME_PATTERN.toRegex()

        fun id(suffix: Long) = ID_PREFIX_NOTEBOOK_PROPERTY.generateId(suffix)
    }

    /**
     * 고유 식별자.
     */
    val id: Uuid

    /**
     * 타입.
     */
    val type: Type

    /**
     * 이름.
     */
    val name: String

    /**
     * 값.
     */
    var value: T
}