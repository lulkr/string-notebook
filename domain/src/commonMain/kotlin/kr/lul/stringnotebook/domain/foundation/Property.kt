package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북, 노트 및 애플리케이션 설정의 속성 종류를 나타내는 인터페이스.
 *
 * @property id 속성 종류의 고유 식별자.
 * @property name 속성 종류의 이름.
 * @property description 속성 종류에 대한 설명.
 */
@ExperimentalUuidApi
sealed class Property(
    val id: Uuid,

    /**
     * @throws IllegalArgumentException [Property.validateName]를 통과하지 못한 경우.
     */
    val name: String,

    /**
     * @throws IllegalArgumentException [Property.validateDescription]를 통과하지 못한 경우.
     */
    val description: String,
) {
    init {
        require(name.isNotBlank()) { "Property type name must not be blank." }

        require(description.isNotBlank()) { "Property type description must not be blank." }
    }

    override fun equals(other: Any?) = this === other || (
            other is Property &&
                    id == other.id &&
                    name == other.name &&
                    description == other.description
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}

/**
 * 단일 값을 가지는 속성.
 */
@ExperimentalUuidApi
abstract class ScalarProperty(
    id: Uuid,
    name: String,
    description: String
) : Property(id, name, description)

/**
 * 복합 속성으로, 여러 개의 하위 속성을 포함하는 속성.
 */
@ExperimentalUuidApi
abstract class CompositeProperty(
    id: Uuid,
    name: String,
    description: String,
    /**
     * 하위 속성들의 이름과 인스턴스의 맵.
     */
    val properties: Map<String, Property>
) : Property(id, name, description) {
    init {
        require(properties.isNotEmpty()) { "Composite property type must have at least one property." }
        require(properties.keys.toSet().size == properties.size) {
            "Composite property type must have unique property names : properties.names=${properties.keys}"
        }
    }
}