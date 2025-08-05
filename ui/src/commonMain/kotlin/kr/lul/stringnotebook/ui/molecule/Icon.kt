package kr.lul.stringnotebook.ui.molecule

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import kr.lul.stringnotebook.state.atom.hasTestTag
import kr.lul.stringnotebook.state.molecule.IconState
import org.jetbrains.compose.resources.painterResource
import kotlin.uuid.ExperimentalUuidApi

/**
 * 아이콘.
 */
@Composable
@ExperimentalUuidApi
fun Icon(icon: IconState, modifier: Modifier = Modifier) {
    logger.v("#Icon args : icon=$icon, modifier=$modifier")

    @Suppress("LocalVariableName") val _modifier = if (modifier.hasTestTag()) {
        logger.w("#Icon modifier already has testTag, ignoring icon's testTag : icon=$icon, modifier=$modifier")
        modifier
    } else {
        modifier.testTag(icon.testTag)
    }

    androidx.compose.material3.Icon(
        painterResource(icon.icon),
        icon.description,
        _modifier,
        icon.tint
    )
}