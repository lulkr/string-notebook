package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북에 배치하거나 참조할 수 있는 객체의 공통 인터페이스입니다.
 */
@OptIn(ExperimentalUuidApi::class)
interface Object<T : ObjectType> {
    /**
     * 오브젝트 ID.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.ID
     */
    val id: Uuid

    /**
     * 오브젝트의 종류.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.T
     */
    var type: T
}