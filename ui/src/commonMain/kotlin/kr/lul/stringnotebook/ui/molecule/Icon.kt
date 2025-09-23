package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.testTag
import kr.lul.stringnotebook.state.molecule.IconState
import kr.lul.stringnotebook.ui.atom.hasTestTag
import kr.lul.stringnotebook.ui.atom.rememberPlaceholderPainter
import org.jetbrains.compose.resources.painterResource
import kotlin.uuid.ExperimentalUuidApi

/**
 * 아이콘.
 */
@Composable
@ExperimentalUuidApi
fun Icon(icon: IconState, modifier: Modifier = Modifier) {
    logger.v("#Icon args : icon=$icon, modifier=$modifier")

    val painter = if (LocalInspectionMode.current) {
        rememberPlaceholderPainter()
    } else {
        painterResource(icon.icon)
    }

    @Suppress("LocalVariableName") val _modifier = if (modifier.hasTestTag()) {
        logger.w("#Icon modifier already has testTag, ignoring icon's testTag : icon=$icon, modifier=$modifier")
        modifier
    } else {
        modifier.testTag(icon.testTag)
    }

    @Suppress("LocalVariableName") val _tint = if (icon.tint == Color.Unspecified) {
        LocalContentColor.current
    } else {
        icon.tint
    }

    androidx.compose.material3.Icon(painter, icon.description, _modifier, _tint)
}