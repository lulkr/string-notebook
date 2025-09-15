package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.organism.AnchorProperties

object AnchorPropertiesDefaults {
    /**
     * 앵커 컨테이너의 기본 패딩.
     *
     * @see AnchorProperties.containerPadding
     */
    val CONTAINER_PADDING_DEFAULT = 4.dp

    /**
     * 앵커의 기본 반지름.
     *
     * @see AnchorProperties.radius
     */
    val RADIUS_DEFAULT: Dp = 4.dp

    @Composable
    fun default(
        /**
         * 앵커 컨테이너의 테두리 상태.
         */
        containerBorder: BorderState = BorderState(1.dp, Color.Transparent, CircleShape),
        /**
         * 앵커 컨테이너의 배경 상태.
         */
        containerBackground: BackgroundState = BackgroundState(),
        /**
         * 앵커 컨테이너의 패딩.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        containerPadding: PaddingValues = PaddingValues(CONTAINER_PADDING_DEFAULT),
        /**
         * 앵커의 배경 상태.
         */
        background: BackgroundState = BackgroundState(),
        /**
         * 앵커의 반지름.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        radius: Dp = RADIUS_DEFAULT,
        /**
         * 앵커의 색상.
         */
        color: Color = MaterialTheme.colorScheme.tertiaryContainer
    ) = AnchorProperties(containerBorder, containerBackground, containerPadding, background, radius, color)

    @Composable
    fun hovered(
        /**
         * 앵커 컨테이너의 테두리 상태.
         */
        containerBorder: BorderState = BorderState(1.dp, MaterialTheme.colorScheme.secondary, CircleShape),
        /**
         * 앵커 컨테이너의 배경 상태.
         */
        containerBackground: BackgroundState = BackgroundState(),
        /**
         * 앵커 컨테이너의 패딩.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        containerPadding: PaddingValues = PaddingValues(CONTAINER_PADDING_DEFAULT),
        /**
         * 앵커의 배경 상태.
         */
        background: BackgroundState = BackgroundState(),
        /**
         * 앵커의 반지름.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        radius: Dp = RADIUS_DEFAULT,
        /**
         * 앵커의 색상.
         */
        color: Color = MaterialTheme.colorScheme.secondary
    ) = AnchorProperties(containerBorder, containerBackground, containerPadding, background, radius, color)
}