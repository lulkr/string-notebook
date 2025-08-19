package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 상태 홀더로 변환.
 */
@ExperimentalUuidApi
val Notebook.state: NotebookState
    get() = NotebookState(id, name, description)