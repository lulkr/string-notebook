package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.state.template.MenuState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@Stable
data class PreviewNotebookContext(
    override val preferences: PreviewNotebookPreferences = PreviewNotebookPreferences(),
    override var version: Uuid = Uuid.random(),
    override var lock: Boolean = false,
    override var active: ObjectState? = null,
    override var menu: MenuState? = null,
) : NotebookContext {
    companion object {
        val Default: PreviewNotebookContext
            get() = PreviewNotebookContext()
    }
}
