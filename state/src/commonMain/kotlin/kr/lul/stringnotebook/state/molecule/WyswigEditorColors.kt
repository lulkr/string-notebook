package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * WYSIWYG 에디터의 색상 설정을 관리하는 데이터 클래스.
 *
 * @property background 에디터의 배경색.
 * @property anchor 앵커 색상 설정.
 */
@Immutable
data class WyswigEditorColors(
    val background: Color = Color.Unspecified,
    val anchor: WyswigAnchorColors = WyswigAnchorColors()
)
