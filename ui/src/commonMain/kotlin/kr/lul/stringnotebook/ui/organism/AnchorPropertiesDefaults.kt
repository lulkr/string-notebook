package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorProperties.Companion.Default

object AnchorPropertiesDefaults {
    @Composable
    fun default(
        /**
         * 앵커 컨테이너의 테두리 상태.
         */
        containerBorder: BorderState = Default.containerBorder,
        /**
         * 앵커 컨테이너의 배경 상태.
         */
        containerBackground: BackgroundState = Default.containerBackground,
        /**
         * 앵커 컨테이너의 패딩.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        containerPadding: PaddingValues = Default.containerPadding,
        /**
         * 앵커의 배경 상태.
         */
        background: BackgroundState = BackgroundState(),
        /**
         * 앵커의 반지름.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        radius: Dp = Default.radius,
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
        containerBorder: BorderState = Default.containerBorder.copy(color = MaterialTheme.colorScheme.secondary),
        /**
         * 앵커 컨테이너의 배경 상태.
         */
        containerBackground: BackgroundState = Default.containerBackground,
        /**
         * 앵커 컨테이너의 패딩.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        containerPadding: PaddingValues = Default.containerPadding,
        /**
         * 앵커의 배경 상태.
         */
        background: BackgroundState = Default.background,
        /**
         * 앵커의 반지름.
         *
         * 전체 컨테이너의 크기는 [radius]와 [containerPadding]의 합으로 결정된다.
         */
        radius: Dp = Default.radius,
        /**
         * 앵커의 색상.
         */
        color: Color = MaterialTheme.colorScheme.secondary
    ) = AnchorProperties(containerBorder, containerBackground, containerPadding, background, radius, color)
}