package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.molecule.AnchorProperties
import kr.lul.stringnotebook.state.molecule.NodeProperties
import kr.lul.stringnotebook.state.organism.PreviewAnchorState
import kr.lul.stringnotebook.state.organism.PreviewNodeState
import kr.lul.stringnotebook.ui.molecule.AnchorPropertiesDefaults
import kr.lul.stringnotebook.ui.molecule.NodePropertiesDefaults
import kotlin.uuid.ExperimentalUuidApi

@Composable
@ExperimentalUuidApi
fun Preview(preview: PreviewAnchorState, properties: AnchorProperties = AnchorPropertiesDefaults.preview()) {
    logger.v("#Preview args : preview=$preview, properties=$properties")

    Box(modifier = Modifier.background(properties.fill, CircleShape).padding(properties.radius))
}

@Composable
@ExperimentalUuidApi
fun Preview(preview: PreviewNodeState, properties: NodeProperties = NodePropertiesDefaults.preview()) {
    logger.v("#Preview args : preview=$preview, properties=$properties")

    Box(
        modifier = Modifier.size(properties.width, properties.height)
            .background(properties.background.brush, properties.background.shape, properties.background.alpha)
            .border(properties.border.width, properties.border.brush, properties.border.shape)
    )
}