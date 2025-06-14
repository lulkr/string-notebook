package kr.lul.stringnotebook.state.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.WyswigEditorColors

/**
 * WYSIWYG 에디터의 상태.
 *
 * @property contentPadding 에디터의 콘텐츠 패딩.
 * @property fontFamily 에디터에서 사용할 기본 폰트.
 */
@Immutable
data class WyswigEditorState(
    val contentPadding: PaddingValues = PaddingValues(4.dp),
    val colors: WyswigEditorColors = WyswigEditorColors(),
    val fontFamily: FontFamily? = null
)
