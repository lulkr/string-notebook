package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.Type
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 표준 타입.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
enum class StandardTypes(
    val type: Type
) {
    LENGTH(LengthType);

    companion object {
        operator fun get(type: Type) = entries.first { it.type == type }

        operator fun get(name: String) = entries.first { it.type.name == name }

        operator fun get(ordinal: Int) = entries[ordinal]

        operator fun get(id: Uuid) = entries.first { it.type.id == id }

        operator fun get(suffix: Long) = entries.first { it.type.id == Type.id(suffix) }
    }
}