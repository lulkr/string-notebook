package kr.lul.stringnotebook.preview.state.organism

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
@Immutable
data class AnchorContainerParams(
    val anchor: AnchorState,
    val properties: AnchorProperties,
    val zIndex: Float = 0F,
    val background: Color = Color.Transparent
)
