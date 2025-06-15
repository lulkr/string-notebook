package kr.lul.stringnotebook.preview.ui.organism

import kr.lul.stringnotebook.state.organism.NotebookPreferences

data class PreviewNotebookPreferences(
    override val anchor: PreviewAnchorPreferences = PreviewAnchorPreferences()
) : NotebookPreferences
