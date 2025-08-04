package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import kr.lul.stringnotebook.state.atom.hasTestTag
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.ui.atom.string
import kr.lul.stringnotebook.ui.organism.logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * [TextState]를 기반으로 한 [androidx.compose.material3.Text] 확장.
 *
 * @see androidx.compose.material3.Text
 */
@Composable
@ExperimentalUuidApi
fun Text(
    state: TextState,
    modifier: Modifier = Modifier,
    onTextLayout: (TextLayoutResult) -> Unit = {}
) {
    logger.v("#Text args : state=$state, modifier=$modifier, onTextLayout=$onTextLayout")

    val text = state.text
        ?: AnnotatedString(state.resource!!.string)

    @Suppress("LocalVariableName")
    val _modifier = if (modifier.hasTestTag()) {
        logger.w("#Text testTag already exists in the modifier : modifier=$modifier")
        modifier
    } else {
        modifier.testTag(state.testTag)
    }

    Text(
        text = text,
        modifier = _modifier,
        color = state.color,
        fontSize = state.fontSize,
        fontStyle = state.fontStyle,
        fontWeight = state.fontWeight,
        fontFamily = state.fontFamily,
        letterSpacing = state.letterSpacing,
        textDecoration = state.textDecoration,
        textAlign = state.textAlign,
        lineHeight = state.lineHeight,
        overflow = state.overflow,
        softWrap = state.softWrap,
        maxLines = state.textLines.max,
        minLines = state.textLines.min,
        onTextLayout = onTextLayout,
        inlineContent = state.inlineContent,
        style = state.style
    )
}
