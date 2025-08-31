package kr.lul.stringnotebook.domain.type

import kr.lul.stringnotebook.domain.foundation.AnchorType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
enum class StandardAnchorTypes(
    val type: AnchorType
) {
    PLAIN(PlainAnchorType);

    companion object {
        operator fun get(ordinal: Int) = entries[ordinal]
        operator fun get(name: String) = valueOf(name)
        operator fun get(type: AnchorType) = entries.first { it.type == type }
        operator fun get(id: Uuid) = entries.first { it.type.id == id }
        operator fun get(suffix: Long) = entries.first { it.type.id == AnchorType.id(suffix) }
    }
}