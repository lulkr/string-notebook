package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import kr.lul.stringnotebook.state.molecule.WyswigAnchorColors
import kr.lul.stringnotebook.state.molecule.WyswigEditorColors

/**
 * 기본 WYSIWYG 노트북 에디터의 색상 설정을 제공하는 객체.
 */
@Immutable
object WyswigEditorDefault {
    /**
     * 기본 색상 설정을 제공합니다.
     *
     * @param background 배경색
     * @param anchor 앵커 색상
     * @param focusedAnchor 선택한 앵커 색상
     *
     * @return WyswigEditorColors 객체
     */
    @Composable
    fun colors(
        background: Color = MaterialTheme.colorScheme.background,
        anchor: WyswigAnchorColors = WyswygAnchorDefault.colors()
    ): WyswigEditorColors = WyswigEditorColors(
        background = background,
        anchor = anchor
    )
}