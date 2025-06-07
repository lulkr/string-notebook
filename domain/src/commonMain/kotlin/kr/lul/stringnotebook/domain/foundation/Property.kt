package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 속성 값.
 *
 * 종류([PropertyType])의 인스턴스에 해당한다.
 *
 * @see V
 */
@OptIn(ExperimentalUuidApi::class)
interface Property<V> {
    @OptIn(ExperimentalStdlibApi::class)
    companion object {
        fun id(suffix: Int) = Configuration.ID_PREFIX_PROPERTY.generateId(suffix)
    }

    /**
     * 속성 ID.
     *
     * @see Companion.id
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.ID
     */
    val id: Uuid

    /**
     * 종류.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.PROPERTY_TYPE
     */
    val type: PropertyType

    /**
     * 값.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.PROPERTY_VALUE
     */
    var value: V
}