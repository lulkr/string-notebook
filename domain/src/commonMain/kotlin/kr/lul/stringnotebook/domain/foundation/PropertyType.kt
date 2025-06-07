package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_TYPE_PROPERTY
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 컨텐츠의 속성 종류.
 */
@OptIn(ExperimentalUuidApi::class)
interface PropertyType {
    @OptIn(ExperimentalStdlibApi::class)
    companion object {
        fun id(suffix: Int) = ID_PREFIX_TYPE_PROPERTY.generateId(suffix)
    }

    /**
     * 속성 종류 ID.
     *
     * @see Companion.id
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.ID
     */
    val id: Uuid

    /**
     * 이름.
     *
     * 사용자가 속성 종류를 식별할 수 있도록 지정한다. 다른 속성의 이름([label])과 중복될 수 있다.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.LABEL
     */
    val label: String

    /**
     * 설명.
     *
     * 사용자가 속성 종류의 용도를 이해할 수 있도록 지정한다. 이름([label])이 중복되더라도 오해하지 않도록 지정한다.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.DESCRIPTION
     */
    val description: String

    /**
     * 속성 종류의 요약 정보.
     */
    val summary: String
        get() = "($id, $label)"
}