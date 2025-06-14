package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.NotebookEditContext
import kr.lul.stringnotebook.state.molecule.WyswigAnchorColors
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.ui.atom.AnchorShape
import kr.lul.stringnotebook.ui.atom.LocalEventProcessor
import kr.lul.stringnotebook.ui.molecule.WyswygAnchorDefault
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
@Composable
fun Anchor(
    state: AnchorState,
    context: NotebookEditContext,
    shape: Shape = AnchorShape,
    colors: WyswigAnchorColors = WyswygAnchorDefault.colors()
) {
    logger.v("#Anchor args : state=$state")

    val backgroundColor = if (context.focused == state.id) {
        colors.focused
    } else {
        colors.inactive
    }
    val borderColor = if (context.focused == state.id) {
        colors.focusedBorder
    } else {
        colors.inactiveBorder
    }

    val eventProcessor = LocalEventProcessor.current
    Box(
        modifier = Modifier
            .clickable { }
            .background(backgroundColor, shape)
            .border(BorderStroke(1.dp, borderColor), shape)
            .size(8.dp)
    ) {
        //
    }
}
