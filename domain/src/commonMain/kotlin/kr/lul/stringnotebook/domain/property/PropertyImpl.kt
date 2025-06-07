package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.Property
import kr.lul.stringnotebook.domain.foundation.PropertyType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 간단한 구현.
 */
@OptIn(ExperimentalUuidApi::class)
open class PropertyImpl<V>(
    override val id: Uuid,
    override val type: PropertyType,
    override var value: V
) : Property<V> {
    override fun equals(other: Any?) = this === other || (
            other is PropertyImpl<*> &&
                    id == other.id &&
                    type == other.type &&
                    value == other.value
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + (value?.hashCode() ?: 0)
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "type=${type.summary}",
        "value=$value"
    ).joinToString(", ", "PropertyImpl(", ")")
}