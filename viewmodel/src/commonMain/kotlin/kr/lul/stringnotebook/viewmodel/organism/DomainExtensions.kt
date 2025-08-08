package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
val Notebook.state: NotebookState
    get() = NotebookState(id)