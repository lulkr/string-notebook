package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun Anchor(
    state: AnchorState
) {
    logger.v("#Anchor args : state=$state")

    Box(modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.outlineVariant).padding(4.dp)) {
    }
}