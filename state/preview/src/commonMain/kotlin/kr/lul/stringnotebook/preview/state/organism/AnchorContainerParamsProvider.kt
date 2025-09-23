package kr.lul.stringnotebook.preview.state.organism

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.preview.state.organism.AnchorStateProvider.Companion.PLAIN_ANCHOR
import kr.lul.stringnotebook.state.atom.CircleBackgroundState
import kr.lul.stringnotebook.state.atom.CircleBorderState
import kr.lul.stringnotebook.state.atom.backgroundDark
import kr.lul.stringnotebook.state.atom.backgroundLight
import kr.lul.stringnotebook.state.atom.secondaryContainerDark
import kr.lul.stringnotebook.state.atom.secondaryContainerLight
import kr.lul.stringnotebook.state.atom.surfaceDark
import kr.lul.stringnotebook.state.atom.surfaceLight
import kr.lul.stringnotebook.state.atom.tertiaryContainerDark
import kr.lul.stringnotebook.state.atom.tertiaryContainerLight
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
class AnchorContainerParamsProvider : PreviewParameterProvider<AnchorContainerParams> {
    override val values = sequenceOf(
        AnchorContainerParams(
            PLAIN_ANCHOR,
            AnchorProperties(
                CircleBorderState(1.dp, Color.Unspecified),
                CircleBackgroundState(Color.Unspecified),
                PaddingValues(0.dp),
                CircleBackgroundState(Color.Unspecified),
                4.dp,
                Color.Transparent
            )
        ),
        AnchorContainerParams(
            AnchorState(name = "light theme - default"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, Color.Transparent),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = tertiaryContainerLight
            ),
            background = backgroundLight
        ),
        AnchorContainerParams(
            AnchorState(name = "light theme - default"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, Color.Transparent),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = tertiaryContainerLight
            ),
            background = surfaceLight
        ),
        AnchorContainerParams(
            AnchorState(name = "light theme - hovered"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, secondaryContainerLight),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = secondaryContainerLight
            ),
            background = backgroundLight
        ),
        AnchorContainerParams(
            AnchorState(name = "light theme - hovered"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, secondaryContainerLight),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = secondaryContainerLight
            ),
            background = surfaceLight
        ),
        AnchorContainerParams(
            AnchorState(name = "dark theme - default"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, Color.Transparent),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = tertiaryContainerDark
            ),
            background = backgroundDark
        ),
        AnchorContainerParams(
            AnchorState(name = "dark theme - default"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, Color.Transparent),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = tertiaryContainerDark
            ),
            background = surfaceDark
        ),
        AnchorContainerParams(
            AnchorState(name = "dark theme - hovered"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, secondaryContainerDark),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = secondaryContainerDark
            ),
            background = backgroundDark
        ),
        AnchorContainerParams(
            AnchorState(name = "dark theme - hovered"),
            AnchorProperties(
                containerBorder = CircleBorderState(1.dp, secondaryContainerDark),
                containerBackground = CircleBackgroundState(Color.Transparent),
                containerPadding = PaddingValues(8.dp),
                background = CircleBackgroundState(Color.Transparent),
                radius = 4.dp,
                color = secondaryContainerDark
            ),
            background = surfaceDark
        )
    )
}