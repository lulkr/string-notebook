package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.molecule.AnchorColors

object AnchorDefaults {
    @Composable
    fun colors(
        inactive: Color = MaterialTheme.colorScheme.outlineVariant,
        active: Color = MaterialTheme.colorScheme.primary,
        inactiveBorder: Color = Color.Transparent,
        activeBorder: Color = MaterialTheme.colorScheme.outline
    ): AnchorColors = AnchorColors(
        inactive = inactive,
        active = active,
        inactiveBorder = inactiveBorder,
        activeBorder = activeBorder
    )
}