package kr.lul.stringnotebook.preview.state.organism

import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kr.lul.stringnotebook.state.molecule.PositionState
import kr.lul.stringnotebook.state.organism.AnchorState
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
class AnchorStateProvider : PreviewParameterProvider<AnchorState> {
    companion object {
        val PLAIN_ANCHOR = AnchorState(
            id = Uuid.random(),
            type = PlainAnchorType,
            name = null,
            memo = null,
            position = PositionState(0F, 0F),
            createdAt = Clock.System.now(),
            updatedAt = Clock.System.now()
        )
    }

    override val values = sequenceOf(
        PLAIN_ANCHOR
    )
}