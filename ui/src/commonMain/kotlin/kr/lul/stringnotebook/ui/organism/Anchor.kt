package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.ActivateEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.molecule.AnchorColors
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookContext
import kr.lul.stringnotebook.ui.molecule.AnchorDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * @see kr.lul.stringnotebook.ui.organism.AnchorPreview
 */
@Composable
@ExperimentalUuidApi
fun Anchor(
    state: AnchorState,
    context: NotebookContext = NotebookContext.NoOp,
    processor: EventProcessor = EventProcessor.NoOp
) {
    logger.v("#Anchor args : state=$state, context=$context, processor=$processor")

    val preferences = context.preferences.anchor
    val default = AnchorDefaults.colors()
    val colors = remember(context) {
        preferences.colors.run {
            AnchorColors(
                inactive = if (Color.Unspecified == inactive) {
                    default.inactive
                } else {
                    inactive
                },
                active = if (Color.Unspecified == active) {
                    default.active
                } else {
                    active
                },
                inactiveBorder = if (Color.Unspecified == inactiveBorder) {
                    default.inactiveBorder
                } else {
                    inactiveBorder
                },
                activeBorder = if (Color.Unspecified == activeBorder) {
                    default.activeBorder
                } else {
                    activeBorder
                }
            )
        }
    }

    Box(
        modifier = Modifier
            .size(preferences.size.dp)
            .clickable(!context.lock && context.active != state) {
                processor(ActivateEvent(target = state.id))
            }
            .border(
                1.dp, if (state == context.active) {
                    colors.activeBorder
                } else {
                    colors.inactiveBorder
                }, RoundedCornerShape(50)
            )
            .background(
                if (state == context.active) {
                    colors.active
                } else {
                    colors.inactive
                }, RoundedCornerShape(50)
            )
    )
}