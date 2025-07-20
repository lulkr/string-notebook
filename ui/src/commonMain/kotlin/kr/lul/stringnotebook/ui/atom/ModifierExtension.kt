package kr.lul.stringnotebook.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.molecule.NodeProperties

fun Modifier.apply(properties: NodeProperties): Modifier = sizeIn(properties.width, properties.height)
    .border(properties.border.width, properties.border.brush, properties.border.shape)
    .background(properties.background.brush, properties.background.shape, properties.background.alpha)
    .padding(properties.padding)