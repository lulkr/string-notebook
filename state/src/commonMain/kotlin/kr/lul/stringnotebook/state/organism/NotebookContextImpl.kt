package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

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