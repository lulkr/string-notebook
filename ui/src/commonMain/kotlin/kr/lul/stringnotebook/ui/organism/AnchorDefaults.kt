package kr.lul.stringnotebook.ui.organism

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Deprecated("use kr.lul.stringnotebook.state.organism.AnchorProperties")
object AnchorDefaults {
    val RADIUS = 8.dp

    /**
     * TODO 상태 홀더 만들기.
     */
    @Composable
    fun hovered() = MaterialTheme.colorScheme.secondaryContainer
}