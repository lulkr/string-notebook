package kr.lul.stringnotebook.state.organism.notebook

import kr.lul.stringnotebook.state.molecule.IconState
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.molecule.TextState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
data class HeaderButtonState(
    val icon: IconState,
    val label: TextState,
    override val key: Any = Uuid.Companion.random(),
    override val testTag: String = key.toString()
) : State