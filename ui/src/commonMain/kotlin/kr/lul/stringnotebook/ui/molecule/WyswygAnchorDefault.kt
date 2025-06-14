package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.molecule.WyswigAnchorColors

@Immutable
object WyswygAnchorDefault {
    @Composable
    fun colors(
        inactive: Color = MaterialTheme.colorScheme.outlineVariant,
        inactiveBorder: Color = Color.Transparent,
        focused: Color = MaterialTheme.colorScheme.primaryContainer,
        focusedBorder: Color = MaterialTheme.colorScheme.primary
    ): WyswigAnchorColors = WyswigAnchorColors(
        inactive = inactive,
        inactiveBorder = inactiveBorder,
        focused = focused,
        focusedBorder = focusedBorder,
    )
}