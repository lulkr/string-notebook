package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북의 편집 컨텍스트.
 *
 * @property preferences 편집중인 노트북의 설정.
 * @property version 컨텍스트 버전. 컨텍스트 상태가 바뀔 때마다 값이 달라진다.
 * @property lock 노트북 자체의 잠금 상태. `true`이면 편집이 불가능하다.
 * @property active 현재 선택한 객체.
 * @property menu 현재 컨텍스트 메뉴 상태.
 */
@Immutable
@OptIn(ExperimentalUuidApi::class)
class NotebookContextImpl(
    override val preferences: NotebookPreferences = NotebookPreferences.NoOp,
    override val version: Uuid = Uuid.random(),
    override val lock: Boolean = false,
    override val active: ObjectState? = null,
    override val menu: MenuState? = null
) : NotebookContext {
    fun copy(
        preferences: NotebookPreferences = this.preferences,
        lock: Boolean = this.lock,
        active: ObjectState? = this.active,
        menu: MenuState? = this.menu,
    ) = NotebookContextImpl(
        preferences = preferences,
        version = Uuid.random(),
        lock = lock,
        active = active,
        menu = menu
    )

    override fun equals(other: Any?) = this === other || (
            other is NotebookContextImpl &&
                    preferences == other.preferences &&
                    version == other.version &&
                    lock == other.lock &&
                    active == other.active &&
                    menu == other.menu
            )

    override fun hashCode(): Int {
        var result = lock.hashCode()
        result = 31 * result + preferences.hashCode()
        result = 31 * result + version.hashCode()
        result = 31 * result + (active?.hashCode() ?: 0)
        result = 31 * result + (menu?.hashCode() ?: 0)
        return result
    }

    override fun toString() = listOf(
        "preferences=$preferences",
        "version=$version",
        "lock=$lock",
        "active=$active",
        "menu=$menu"
    ).joinToString(", ", "NotebookContextImpl(", ")")
}