package kr.lul.stringnotebook.domain.event

import kr.lul.stringnotebook.domain.foundation.Event
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 컨텍스트 메뉴를 표시하는 이벤트
 *
 * @param x 메뉴를 표시할 x 좌표. [androidx.compose.ui.unit.Dp] 단위.
 * @param y 메뉴를 표시할 y 좌표. [androidx.compose.ui.unit.Dp] 단위.
 * @param target 메뉴가 적용될 대상 객체의 ID (선택적). `null`이면 노트북 자체의 컨텍스트 메뉴를 표시합니다.
 */
@ExperimentalUuidApi
data class ShowContextMenuEvent(
    val x: Float,
    val y: Float,
    val target: Uuid? = null
) : Event {
    override val id: Uuid = Uuid.random()

    override fun toString() = "ShowContextMenuEvent(id=$id, x=$x, y=$y, target=$target)"
}
