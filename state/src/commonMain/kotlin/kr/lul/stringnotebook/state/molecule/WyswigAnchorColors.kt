package kr.lul.stringnotebook.state.molecule

import androidx.compose.ui.graphics.Color

/**
 * 앵커 색상.
 *
 * @property inactive 비활성 상태의 색상(기본).
 * @property inactiveBorder 비활성 상태의 테두리 색상.
 * @property focused 선택한 상태의 색상.
 * @property focusedBorder 선택한 상태의 테두리 색상.
 */
data class WyswigAnchorColors(
    val inactive: Color = Color.Transparent,
    val inactiveBorder: Color = Color.Unspecified,
    val focused: Color = Color.Unspecified,
    val focusedBorder: Color = Color.Unspecified
)
