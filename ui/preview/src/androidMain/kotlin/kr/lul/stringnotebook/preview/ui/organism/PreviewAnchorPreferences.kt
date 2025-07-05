package kr.lul.stringnotebook.preview.ui.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.AnchorColors
import kr.lul.stringnotebook.state.organism.AnchorPreferences

@Immutable
data class PreviewAnchorPreferences(
    override val size: Float = AnchorPreferences.Default.size,
    override val colors: AnchorColors = AnchorColors()
) : AnchorPreferences
