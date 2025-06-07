package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 오브젝트의 종류.
 */
@OptIn(ExperimentalUuidApi::class)
interface ObjectType {
    /**
     * 오브젝트 ID.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.ID
     */
    val id: Uuid

    /**
     * 이름.
     *
     * 사용자가 오브젝트의 종류를 유추할 수 있는 이름. 다른 이름([label])과 중복될 수 있다.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.LABEL
     */
    val label: String

    /**
     * 설명.
     *
     * 사용자가 속성 오브젝트 종류의 용도를 이해할 수 있도록 지정한다. 이름([label])이 중복되더라도 오해하지 않도록 지정한다.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.DESCRIPTION
     */
    val description: String

    val summary: String
        get() = "($id, $label)"
}