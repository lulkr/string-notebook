package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@Immutable
data class PreviewNotebookContext(
    override val preferences: PreviewNotebookPreferences = PreviewNotebookPreferences(),
    override var version: Uuid = Uuid.random(),
    override val lock: Boolean = false,
    override var active: ObjectState? = null,
    override val menu: MenuState? = null,
) : NotebookContext {
    companion object {
        val Default = PreviewNotebookContext()
    }
}
