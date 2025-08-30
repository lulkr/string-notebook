package kr.lul.stringnotebook.domain.anchor

import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.property.PositionProperty
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 변경 사항을 감지할 수 있는 앵커 래퍼.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
open class ObservableAnchor(
    /**
     * 관찰할 앵커.
     */
    val anchor: Anchor,
    /**
     * 앵커 변경 콜백. [anchor] 변경 후 호출한다.
     *
     * @see beforeChange
     */
    val afterChange: ObservableAnchor.() -> Unit
) : Anchor {
    override val id: Uuid = anchor.id
    override var type: AnchorType
        get() = anchor.type
        set(value) {
            anchor.type = value
            afterChange()
        }
    override val position: PositionProperty
        get() = anchor.position
    override var name: String?
        get() = anchor.name
        set(value) {
            beforeChange()
            anchor.name = value
            afterChange()
        }
    override var memo: String?
        get() = anchor.memo
        set(value) {
            beforeChange()
            anchor.memo = value
            afterChange()
        }
    override val createdAt: Instant = anchor.createdAt
    override val updatedAt: Instant
        get() = anchor.updatedAt

    /**
     * 앵커 변경 전 콜백. [anchor] 변경 전에 호출한다.
     *
     * @see afterChange
     */
    open fun beforeChange() {}

    override fun equals(other: Any?) = this === other || (
            other is ObservableAnchor &&
                    anchor == other.anchor &&
                    afterChange == other.afterChange
            )

    override fun hashCode(): Int {
        var result = anchor.hashCode()
        result = 31 * result + afterChange.hashCode()
        return result
    }

    override fun toString() = "ObservableAnchor(anchor=$anchor, onChange=$afterChange)"
}