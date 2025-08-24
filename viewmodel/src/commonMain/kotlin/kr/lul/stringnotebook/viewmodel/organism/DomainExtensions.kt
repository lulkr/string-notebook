package kr.lul.stringnotebook.viewmodel.organism

import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.domain.property.PositionProperty
import kr.lul.stringnotebook.state.molecule.PositionState
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 상태 홀더로 변환.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
val Notebook.state: NotebookState
    get() = NotebookState(id, name, memo, anchors.map { it.state }, null, createdAt, updatedAt)

@ExperimentalStdlibApi
@ExperimentalUuidApi
val Anchor.state: AnchorState
    get() = AnchorState(id, type, name, memo, position.state, createdAt, updatedAt)

@ExperimentalStdlibApi
@ExperimentalUuidApi
val PositionProperty.state: PositionState
    get() = PositionState(x.value, y.value)