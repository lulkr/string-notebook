package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.PropertyType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 기본 속성 종류.
 */
@OptIn(ExperimentalUuidApi::class)
enum class StandardPropertyType(
    override val id: Uuid,
    override val label: String,
    override val description: String,
) : PropertyType {
    ID(1, "id", "속성의 고유 식별자. 노트북 컨텐츠의 속성은 반드시 이 속성을 포함해야 한다."),
    LABEL(2, "label", "속성의 이름. 사용자가 속성을 식별할 수 있도록 지정한다. 다른 속성의 이름과 중복될 수 있다."),
    DESCRIPTION(3, "description", "속성의 설명. 사용자가 속성의 용도를 이해할 수 있도록 지정한다. 이름이 중복되더라도 오해하지 않도록 지정한다."),
    PROPERTY_TYPE(4, "type", "속성의 종류. 노트북 컨텐츠의 속성은 반드시 이 속성을 포함해야 한다."),
    PROPERTY_VALUE(5, "value", "설정된 속성의 값. 노트북 컨텐츠의 속성은 반드시 이 속성을 포함해야 한다.");

    constructor(id: Int, label: String, description: String) : this(PropertyType.id(id), label, description)
}
