package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.state.organism.ObjectState

@Immutable
data class PreviewNotebookContext(
    override val preferences: PreviewNotebookPreferences = PreviewNotebookPreferences(),
    override val lock: Boolean = false,
    override var active: ObjectState? = null
) : NotebookContext {
    companion object {
        val Default = PreviewNotebookContext()
    }
}
