package kr.lul.stringnotebook.domain.anchor

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.property.PositionProperty
import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 단순한 위치를 나타내는 앵커.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class PlainAnchor(
    override val id: Uuid = Anchor.id(),
    position: PositionProperty = PositionProperty(x = 0F, y = 0F),
    override val createdAt: Instant = Clock.System.now(),
) : Anchor {
    override var type: AnchorType = PlainAnchorType
    override var name: String? = null
    override var memo: String? = null
    override var position: PositionProperty = position
    override val updatedAt: Instant = createdAt

    override fun equals(other: Any?) = this === other || (
            other is PlainAnchor &&
                    id == other.id &&
                    position == other.position &&
                    name == other.name &&
                    memo == other.memo &&
                    createdAt == other.createdAt &&
                    updatedAt == other.updatedAt
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + updatedAt.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "name=$name",
        "memo=$memo",
        "position=$position",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt"
    ).joinToString(", ", "PlainAnchor(", ")")
}