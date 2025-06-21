package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북의 편집 컨텍스트.
 *
 * @property preferences 편집중인 노트북의 설정.
 * @property lock 노트북 자체의 잠금 상태. `true`이면 편집이 불가능하다.
 * @property active 현재 선택한 객체.
 * @property menu 현재 컨텍스트 메뉴 상태.
 */
@ExperimentalUuidApi
class NotebookContextImpl(
    override val preferences: NotebookPreferences = NotebookPreferences.NoOp,
    lock: Boolean = false,
    active: ObjectState? = null,
    menu: MenuState? = null
) : NotebookContext {
    override var lock: Boolean by mutableStateOf(lock)
    override var active: ObjectState? by mutableStateOf(active)
    override var menu: MenuState? by mutableStateOf(menu)

    override fun equals(other: Any?) = this === other || (
            other is NotebookContextImpl &&
                    preferences == other.preferences &&
                    lock == other.lock &&
                    active == other.active &&
                    menu == other.menu
            )

    override fun hashCode(): Int {
        var result = preferences.hashCode()
        result = 31 * result + lock.hashCode()
        result = 31 * result + (active?.hashCode() ?: 0)
        result = 31 * result + (menu?.hashCode() ?: 0)
        return result
    }

    override fun toString() = listOf(
        "preferences=$preferences",
        "lock=$lock",
        "active=$active",
        "menu=$menu"
    ).joinToString(", ", "NotebookContextImpl(", ")")
}