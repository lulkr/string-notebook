package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_PROPERTY_TYPE
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북, 노트 및 애플리케이션 설정의 속성 종류를 나타내는 인터페이스.
 *
 * @property id 속성 종류의 고유 식별자.
 * @property name 속성 종류의 이름.
 * @property description 속성 종류에 대한 설명.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
sealed class PropertyType(
    val id: Uuid,
    val name: String,
    val description: String
) {
    companion object {
        /**
         * @see ID_PREFIX_NOTEBOOK_PROPERTY_TYPE
         */
        internal fun id(id: Long) = ID_PREFIX_NOTEBOOK_PROPERTY_TYPE.generateId(id)
    }

    init {
        require(name.isNotBlank()) { "name must not be blank." }
        require(description.isNotBlank()) { "description must not be blank." }
    }

    override fun equals(other: Any?) = this === other || (
            other is PropertyType &&
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

    override fun toString() = "id=$id, name=$name, description=$description"
}

/**
 * 쪼갤 수 없는 단일 값을 가지는 속성.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class ScalarPropertyType(
    id: Uuid,
    name: String,
    description: String
) : PropertyType(id, name, description)

/**
 * 복합 속성으로, 여러 개의 하위 속성을 포함하는 속성.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class CompositePropertyType(
    id: Uuid,
    name: String,
    description: String,
    /**
     * 하위 속성들의 이름과 인스턴스의 맵.
     */
    val properties: Map<String, PropertyType>
) : PropertyType(id, name, description) {
    init {
        require(properties.isNotEmpty()) { "properties must have at least one property." }
        require(properties.keys.toSet().size == properties.size) {
            "properties must have unique property names : properties.names=${properties.keys}"
        }
    }

    override fun equals(other: Any?) = this === other || (
            other is CompositePropertyType &&
                    id == other.id &&
                    name == other.name &&
                    description == other.description &&
                    properties == other.properties
            )

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + properties.hashCode()
        return result
    }

    override fun toString() = super.toString() + ", properties=$properties"
}