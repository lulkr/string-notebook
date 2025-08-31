package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.PropertyType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 표준 타입.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
enum class StandardPropertyTypes(
    val type: PropertyType
) {
    LENGTH(LengthPropertyType),
    SIZE(SizePropertyType),
    POSITION(PositionPropertyType),
    COLOR(ColorPropertyType);

    companion object Companion {
        operator fun get(type: PropertyType) = entries.first { it.type == type }

        operator fun get(name: String) = entries.first { it.type.name.equals(name, true) }

        operator fun get(ordinal: Int) = entries[ordinal]

        operator fun get(id: Uuid) = entries.first { it.type.id == id }

        operator fun get(suffix: Long) = entries.first { it.type.id == PropertyType.id(suffix) }
    }
}