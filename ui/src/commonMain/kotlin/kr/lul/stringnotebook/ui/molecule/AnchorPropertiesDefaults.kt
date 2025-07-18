package kr.lul.stringnotebook.ui.molecule

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.molecule.AnchorProperties

/**
 * [AnchorProperties]의 기본값을 제공하는 객체입니다.
 */
object AnchorPropertiesDefaults {
    /**
     * 앵커의 기본 반지름.
     */
    val RADIUS = 4.dp

    /**
     * 기본 상태
     *
     * @param radius 반지름.
     * @param fill 채우기 브러시.
     */
    @Composable
    fun default(
        radius: Dp = RADIUS,
        fill: Brush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75F))
    ) = AnchorProperties(radius, fill)

    /**
     * 커서가 올라간 경우.
     *
     * @param radius 반지름.
     * @param fill 채우기 브러시.
     */
    @Composable
    fun hover(
        radius: Dp = RADIUS,
        fill: Brush = SolidColor(MaterialTheme.colorScheme.secondary)
    ) = AnchorProperties(radius, fill)

    /**
     * 선택한 경우.
     *
     * @param radius 반지름.
     * @param fill 채우기 브러시.
     */
    @Composable
    fun focused(
        radius: Dp = RADIUS,
        fill: Brush = SolidColor(MaterialTheme.colorScheme.primary)
    ) = AnchorProperties(radius, fill)

    /**
     * 드래그&드랍 조작 중인 경우.
     *
     * @param radius 반지름.
     * @param fill 채우기 브러시.
     */
    @Composable
    fun preview(
        radius: Dp = RADIUS,
        fill: Brush = SolidColor(MaterialTheme.colorScheme.primaryContainer)
    ) = AnchorProperties(radius, fill)
}