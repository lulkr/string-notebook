package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.molecule.AnchorProperties
import kr.lul.stringnotebook.state.organism.PreviewAnchorState
import kr.lul.stringnotebook.ui.molecule.AnchorPropertiesDefaults
import kr.lul.stringnotebook.ui.page.logger
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun Preview(preview: PreviewAnchorState, properties: AnchorProperties = AnchorPropertiesDefaults.preview()) {
    logger.v("#Preview args : preview=$properties, properties=$properties")

    Box(modifier = Modifier.background(properties.fill, CircleShape).padding(properties.radius))
}