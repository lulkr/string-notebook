package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.atom.LocalEventProcessor
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun Anchor(
    state: AnchorState
) {
    logger.v("#Anchor args : state=$state")

    val eventProcessor = LocalEventProcessor.current
    Box(
        modifier = Modifier
            .clickable { }
            .background(MaterialTheme.colorScheme.tertiaryContainer, RoundedCornerShape(4.dp))
            .size(8.dp)
    ) {
        //
    }
}
