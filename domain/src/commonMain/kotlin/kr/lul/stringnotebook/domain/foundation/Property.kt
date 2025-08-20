package kr.lul.stringnotebook.domain.foundation

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_PROPERTY
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kr.lul.stringnotebook.domain.foundation.Property.Companion.NAME_REGEX
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [PropertyType]의 인스턴스.
 *
 * @param T 스트링노트 앱 내부에서 사용하는 타입.
 *
 * @see PropertyType
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
sealed interface Property {
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
    val type: PropertyType

    /**
     * 이름.
     */
    val name: String
}

@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class ScalarProperty<T>(
    override val id: Uuid,
    override val type: ScalarPropertyType,
    override val name: String,
) : Property {
    abstract var value: T

    init {
        require("$id".startsWith(ID_PREFIX_NOTEBOOK_PROPERTY, true)) {
            "illegal id prefix : id=$id, prefix=$ID_PREFIX_NOTEBOOK_PROPERTY"
        }
        require(NAME_REGEX.matches(name)) {
            "illegal name pattern : name='$name', regex=$NAME_REGEX"
        }
    }

    override fun equals(other: Any?) = this === other || (
            other is ScalarProperty<*> &&
                    id == other.id &&
                    type == other.type &&
                    name == other.name &&
                    value == other.value
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + (value?.hashCode() ?: 0)
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name=$name",
        "value=$value"
    ).joinToString(", ")
}

@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class CompositeProperty(
    override val id: Uuid,
    override val type: CompositePropertyType,
    override val name: String,
    val children: Map<String, Property>
) : Property {
    init {
        require("$id".lowercase().startsWith(ID_PREFIX_NOTEBOOK_PROPERTY.lowercase())) {
            "illegal id prefix : id=$id, prefix=$ID_PREFIX_NOTEBOOK_PROPERTY"
        }
        require(NAME_REGEX.matches(name)) {
            "illegal name pattern : name='$name', regex=$NAME_REGEX"
        }
        require(children.isNotEmpty()) {
            "properties must not be empty: properties=$children"
        }
        require(children.size == children.keys.toSet().size) {
            "properties must not have duplicate keys: properties.keys=${children.keys}"
        }
        for (child in children.keys) {
            require(NAME_REGEX.matches(child)) {
                "illegal child name pattern : name='$child', regex=$NAME_REGEX"
            }
        }
    }

    override fun equals(other: Any?) = this === other || (
            other is CompositeProperty &&
                    id == other.id &&
                    type == other.type &&
                    name == other.name &&
                    children == other.children
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + children.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name=$name",
        "children=$children"
    ).joinToString(", ")
}