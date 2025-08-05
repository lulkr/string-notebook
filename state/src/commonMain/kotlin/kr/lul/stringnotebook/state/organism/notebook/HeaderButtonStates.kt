package kr.lul.stringnotebook.state.organism.notebook

import kr.lul.stringnotebook.state.atom.TextResource
import kr.lul.stringnotebook.state.molecule.NewNotebookIcon
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.organism_new_notebook_label
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
val NewNotebookHeaderButton = HeaderButtonState(
    icon = NewNotebookIcon,
    label = TextState(TextResource(Res.string.organism_new_notebook_label))
)