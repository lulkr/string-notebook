package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorProperties.Companion.Default

/**
 * [Anchor]를 화면에 표시하기 위한 속성의 기본값 모음.
 */
object AnchorPropertiesDefaults {
    /**
     * 기본 앵커 속성.
     */
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

    /**
     * 기본 앵커 속성.
     *
     * 전달된 [properties]를 기본으로 필요한 속성을 덮어쓴다.
     */
    @Composable
    fun default(properties: AnchorProperties?): AnchorProperties {
        if (properties == null)
            return default()

        val containerBorder = if (
            (properties.containerBorder.brush as? SolidColor)?.value == Color.Unspecified
        ) {
            properties.containerBorder.copy(color = Color.Transparent)
        } else {
            properties.containerBorder
        }

        val containerBackground = if (
            (properties.containerBackground.brush as? SolidColor)?.value == Color.Unspecified
        ) {
            properties.containerBackground.copy(brush = SolidColor(Color.Transparent))
        } else {
            properties.containerBackground
        }

        val color = if (properties.color == Color.Unspecified) {
            MaterialTheme.colorScheme.tertiaryContainer
        } else {
            properties.color
        }

        return properties.copy(
            containerBorder = containerBorder,
            containerBackground = containerBackground,
            color = color
        )
    }

    /**
     * 호버된 앵커 속성.
     */
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

    /**
     * 호버된 앵커 속성.
     *
     * 전달된 [properties]를 기본으로 필요한 속성을 덮어쓴다.
     */
    @Composable
    fun hovered(properties: AnchorProperties?): AnchorProperties {
        if (properties == null)
            return hovered()

        val containerBorder = if (
            (properties.containerBorder.brush as? SolidColor)?.value == Color.Unspecified
        ) {
            properties.containerBorder.copy(color = MaterialTheme.colorScheme.secondary)
        } else {
            properties.containerBorder
        }

        val containerBackground = if (
            (properties.containerBackground.brush as? SolidColor)?.value == Color.Unspecified
        ) {
            properties.containerBackground.copy(brush = SolidColor(Color.Transparent))
        } else {
            properties.containerBackground
        }

        val color = if (properties.color == Color.Unspecified) {
            MaterialTheme.colorScheme.secondary
        } else {
            properties.color
        }

        return properties.copy(
            containerBorder = containerBorder,
            containerBackground = containerBackground,
            color = color
        )
    }
}