package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Deprecated("see AnchorContainerPropertiesDefaults")
@Immutable
data class AnchorColors(
    val inactive: Color = Color.Unspecified,
    val active: Color = Color.Unspecified,
    val inactiveBorder: Color = Color.Unspecified,
    val activeBorder: Color = Color.Unspecified
)
