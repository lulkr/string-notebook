package kr.lul.stringnotebook.data.entity

import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.property.PositionProperty
import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
class AnchorEntity(
    override val id: Uuid = Uuid.random(),
    type: AnchorType = PlainAnchorType,
    name: String? = null,
    memo: String? = null,
    position: PositionProperty = PositionProperty(x = 0F, y = 0F),
    override val createdAt: Instant = Clock.System.now()
) : Anchor {
    override var type: AnchorType = type
    override val position: PositionProperty = position
    override var name: String? = name
    override var memo: String? = memo
    override var updatedAt: Instant = createdAt
        private set

    override fun equals(other: Any?) = this === other || (
            other is AnchorEntity &&
                    id == other.id &&
                    type == other.type &&
                    name == other.name &&
                    memo == other.memo &&
                    position == other.position &&
                    createdAt == other.createdAt &&
                    updatedAt == other.updatedAt
            )

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + createdAt.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (memo?.hashCode() ?: 0)
        result = 31 * result + updatedAt.hashCode()
        return result
    }

    override fun toString() = listOf(
        "id=$id",
        "type=$type",
        "name=$name",
        "memo=$memo",
        "position=$position",
        "createdAt=$createdAt",
        "updatedAt=$updatedAt"
    ).joinToString(", ", "AnchorEntity(", ")")
}