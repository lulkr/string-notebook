package kr.lul.stringnotebook.ui.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableValue
import androidx.compose.ui.platform.testTag
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState

/**
 * [Modifier]가 속성을 가지고 있는지 확인하는 확장 함수.
 *
 * @param name 확인할 속성의 이름.
 */
fun Modifier.hasElement(name: String): Boolean = foldIn(false) { found, element ->
    found || (element is InspectableValue && element.nameFallback == name)
}

/**
 * [Modifier.testTag]가 설정되어 있는지 확인하는 확장 함수.
 *
 * @see testTag
 */
fun Modifier.hasTestTag(): Boolean = hasElement("testTag")

fun Modifier.border(border: BorderState): Modifier = border(
    border.width,
    border.brush,
    border.shape
)

fun Modifier.background(background: BackgroundState): Modifier = background(
    background.brush,
    background.shape,
    background.alpha
)