package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Immutable
@OptIn(ExperimentalUuidApi::class)
data class NotebookContextImpl(
    override val preferences: NotebookPreferences = NotebookPreferences.NoOp,
    override val version: Uuid = Uuid.random(),
    override val lock: Boolean = false,
    override val active: ObjectState? = null,
    override val menu: MenuState? = null
) : NotebookContext