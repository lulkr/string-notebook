package kr.lul.stringnotebook.ui.organism.notebook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.ButtonHandler
import kr.lul.stringnotebook.state.organism.notebook.HeaderButtonState
import kr.lul.stringnotebook.ui.atom.logger
import kr.lul.stringnotebook.ui.molecule.Icon
import kr.lul.stringnotebook.ui.molecule.Text
import kotlin.uuid.ExperimentalUuidApi

/**
 * - 디자인 : [ListHeaderButton](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-1766)
 */
@Composable
@ExperimentalUuidApi
fun ListHeaderButton(
    state: HeaderButtonState,
    handler: ButtonHandler = ButtonHandler.NoOp
) {
    logger.v("#ListHeaderButton args : state=$state, handler=$handler")

    Column(
        modifier = Modifier
            .clickable(
                enabled = state.enabled,
                onClick = handler::onClick
            )
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(state.icon)
        Spacer(Modifier.height(8.dp))
        Text(state.label)
    }
}