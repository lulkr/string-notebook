package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_TYPE
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북, 노트 및 애플리케이션 설정의 속성 종류를 나타내는 인터페이스.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
sealed class Type(
    /**
     * 고유 식별자.
     *
     * @see ID_PREFIX_NOTEBOOK_TYPE
     */
    val id: Uuid,
    /**
     * 이름.
     */
    val name: String,
    /**
     * 타입에 관한 간단한 설명.
     */
    val description: String
) {
    companion object {
        /**
         * @see ID_PREFIX_NOTEBOOK_TYPE
         */
        internal fun id(suffix: Long) = ID_PREFIX_NOTEBOOK_TYPE.generateId(suffix)
    }

    init {
        require("$id".lowercase().startsWith(ID_PREFIX_NOTEBOOK_TYPE.lowercase())) {
            "illegal id prefix : id=$id, prefix=$ID_PREFIX_NOTEBOOK_TYPE"
        }
        require(name.isNotBlank()) { "name must not be blank." }
        require(description.isNotBlank()) { "description must not be blank." }
    }

    override fun equals(other: Any?) = this === other || (
            other is Type &&
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
 * 쪼갤 수 없는 단일 값을 가지는 타입.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class ScalarType(
    id: Uuid,
    name: String,
    description: String
) : Type(id, name, description)

/**
 * 여러 속성을 가진 타입으로, 여러 개의 하위 속성을 포함하는 타입.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class CompositeType(
    id: Uuid,
    name: String,
    description: String,
    /**
     * 하위 속성들의 이름과 인스턴스의 맵.
     */
    val properties: Map<String, Type>
) : Type(id, name, description) {
    companion object {
        const val PROPERTY_NAME_PATTERN = "[a-z][A-Za-z0-9_]*"
        val PROPERTY_NAME_REGEX = PROPERTY_NAME_PATTERN.toRegex()
    }

    init {
        require(properties.isNotEmpty()) { "properties must have at least one property." }
        require(properties.keys.toSet().size == properties.size) {
            "properties must have unique property names : properties.names=${properties.keys}"
        }
        for (name in properties.keys) {
            require(PROPERTY_NAME_REGEX.matches(name)) {
                "illegal property name : name=$name, pattern=$PROPERTY_NAME_PATTERN"
            }
        }
    }

    override fun equals(other: Any?) = this === other || (
            other is CompositeType &&
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