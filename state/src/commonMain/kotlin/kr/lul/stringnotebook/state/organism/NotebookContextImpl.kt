package kr.lul.stringnotebook.state.organism

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
@ExperimentalUuidApi
class NotebookContextImpl(
    override val preferences: NotebookPreferences = NotebookPreferences.NoOp,
    version: Uuid = Uuid.random(),
    lock: Boolean = false,
    active: ObjectState? = null,
    menu: MenuState? = null
) : NotebookContext {
    override var version: Uuid = version
        private set
    override var lock: Boolean = lock
        set(value) {
            version = Uuid.random()
            field = value
        }
    override var active: ObjectState? = active
        set(value) {
            version = Uuid.random()
            field = value
        }
    override var menu: MenuState? = menu
        set(value) {
            version = Uuid.random()
            field = value
        }

    override fun equals(other: Any?) = this === other || (
            other is NotebookContextImpl &&
                    preferences == other.preferences &&
                    version == other.version &&
                    lock == other.lock &&
                    active == other.active &&
                    menu == other.menu
            )

    override fun hashCode(): Int {
        var result = preferences.hashCode()
        result = 31 * result + version.hashCode()
        result = 31 * result + lock.hashCode()
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