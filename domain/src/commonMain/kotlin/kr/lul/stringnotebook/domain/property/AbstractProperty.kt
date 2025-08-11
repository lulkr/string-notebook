package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_PROPERTY
import kr.lul.stringnotebook.domain.foundation.Property
import kr.lul.stringnotebook.domain.foundation.Property.Companion.NAME_REGEX
import kr.lul.stringnotebook.domain.foundation.Type
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
abstract class AbstractProperty<T>(
    override val id: Uuid,
    override val type: Type,
    override val name: String
) : Property<T> {
    init {
        require("$id".lowercase().startsWith(ID_PREFIX_NOTEBOOK_PROPERTY.lowercase())) {
            "illegal id prefix : id=$id, prefix=$ID_PREFIX_NOTEBOOK_PROPERTY"
        }
        require(NAME_REGEX.matches(name)) {
            "illegal name pattern : name='$name', regex=$NAME_REGEX"
        }
    }

    override fun equals(other: Any?) = this === other || (
            other is AbstractProperty<*> &&
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
        "type=$type",
        "name=$name",
        "value=$value"
    ).joinToString(", ")
}