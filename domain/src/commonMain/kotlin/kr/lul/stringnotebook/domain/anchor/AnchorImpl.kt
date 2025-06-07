package kr.lul.stringnotebook.domain.anchor

import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 간단한 구현.
 */
@OptIn(ExperimentalUuidApi::class)
open class AnchorImpl(
    override val id: Uuid,
    override var type: AnchorType,
    override var x: Int,
    override var y: Int
) : Anchor {
    override fun equals(other: Any?) = this === other || (
            other is AnchorImpl &&
                    id == other.id &&
                    type == other.type &&
                    x == other.x &&
                    y == other.y
            )

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        result = 31 * result + id.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "type=${type.summary}",
        "x=$x",
        "y=$y"
    ).joinToString(", ", "AnchorImpl(", ")")
}