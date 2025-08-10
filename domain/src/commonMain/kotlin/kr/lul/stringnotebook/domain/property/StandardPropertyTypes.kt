package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.PropertyType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
enum class StandardPropertyTypes(
    val type: PropertyType
) {
    LENGTH(LengthPropertyType);

    companion object {
        operator fun get(type: PropertyType) = entries.first { it.type == type }

        operator fun get(name: String) = entries.first { it.type.name == name }

        operator fun get(ordinal: Int) = entries[ordinal]

        operator fun get(id: Uuid) = entries.first { it.type.id == id }

        operator fun get(id: Long) = entries.first { it.type.id == PropertyType.id(id) }
    }
}