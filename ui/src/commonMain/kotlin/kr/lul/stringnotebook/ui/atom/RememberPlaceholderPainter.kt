package kr.lul.stringnotebook.ui.atom

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import kr.lul.stringnotebook.state.atom.PlaceholderPainter


@Composable
fun rememberPlaceholderPainter(
    foreground: Color = Color.Unspecified,
    background: Color = Color.Unspecified
): Painter {
    val fg = if (foreground == Color.Unspecified) {
        MaterialTheme.colorScheme.outline
    } else {
        foreground
    }
    val bg = if (background == Color.Unspecified) {
        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
    } else {
        background
    }
    val painter = remember(bg, fg) { PlaceholderPainter(fg, bg) }
    logger.v("#rememberPlaceholderPainter : ($fg, $bg) => $painter")
    return painter
}