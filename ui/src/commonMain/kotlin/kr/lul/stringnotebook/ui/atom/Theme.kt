package kr.lul.stringnotebook.ui.atom

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.atom.backgroundDark
import kr.lul.stringnotebook.state.atom.backgroundDarkHighContrast
import kr.lul.stringnotebook.state.atom.backgroundDarkMediumContrast
import kr.lul.stringnotebook.state.atom.backgroundLight
import kr.lul.stringnotebook.state.atom.backgroundLightHighContrast
import kr.lul.stringnotebook.state.atom.backgroundLightMediumContrast
import kr.lul.stringnotebook.state.atom.errorContainerDark
import kr.lul.stringnotebook.state.atom.errorContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.errorContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.errorContainerLight
import kr.lul.stringnotebook.state.atom.errorContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.errorContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.errorDark
import kr.lul.stringnotebook.state.atom.errorDarkHighContrast
import kr.lul.stringnotebook.state.atom.errorDarkMediumContrast
import kr.lul.stringnotebook.state.atom.errorLight
import kr.lul.stringnotebook.state.atom.errorLightHighContrast
import kr.lul.stringnotebook.state.atom.errorLightMediumContrast
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceDark
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceDarkHighContrast
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceDarkMediumContrast
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceLight
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceLightHighContrast
import kr.lul.stringnotebook.state.atom.inverseOnSurfaceLightMediumContrast
import kr.lul.stringnotebook.state.atom.inversePrimaryDark
import kr.lul.stringnotebook.state.atom.inversePrimaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.inversePrimaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.inversePrimaryLight
import kr.lul.stringnotebook.state.atom.inversePrimaryLightHighContrast
import kr.lul.stringnotebook.state.atom.inversePrimaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.inverseSurfaceDark
import kr.lul.stringnotebook.state.atom.inverseSurfaceDarkHighContrast
import kr.lul.stringnotebook.state.atom.inverseSurfaceDarkMediumContrast
import kr.lul.stringnotebook.state.atom.inverseSurfaceLight
import kr.lul.stringnotebook.state.atom.inverseSurfaceLightHighContrast
import kr.lul.stringnotebook.state.atom.inverseSurfaceLightMediumContrast
import kr.lul.stringnotebook.state.atom.onBackgroundDark
import kr.lul.stringnotebook.state.atom.onBackgroundDarkHighContrast
import kr.lul.stringnotebook.state.atom.onBackgroundDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onBackgroundLight
import kr.lul.stringnotebook.state.atom.onBackgroundLightHighContrast
import kr.lul.stringnotebook.state.atom.onBackgroundLightMediumContrast
import kr.lul.stringnotebook.state.atom.onErrorContainerDark
import kr.lul.stringnotebook.state.atom.onErrorContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.onErrorContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onErrorContainerLight
import kr.lul.stringnotebook.state.atom.onErrorContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.onErrorContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.onErrorDark
import kr.lul.stringnotebook.state.atom.onErrorDarkHighContrast
import kr.lul.stringnotebook.state.atom.onErrorDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onErrorLight
import kr.lul.stringnotebook.state.atom.onErrorLightHighContrast
import kr.lul.stringnotebook.state.atom.onErrorLightMediumContrast
import kr.lul.stringnotebook.state.atom.onPrimaryContainerDark
import kr.lul.stringnotebook.state.atom.onPrimaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.onPrimaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onPrimaryContainerLight
import kr.lul.stringnotebook.state.atom.onPrimaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.onPrimaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.onPrimaryDark
import kr.lul.stringnotebook.state.atom.onPrimaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.onPrimaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onPrimaryLight
import kr.lul.stringnotebook.state.atom.onPrimaryLightHighContrast
import kr.lul.stringnotebook.state.atom.onPrimaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.onSecondaryContainerDark
import kr.lul.stringnotebook.state.atom.onSecondaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.onSecondaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onSecondaryContainerLight
import kr.lul.stringnotebook.state.atom.onSecondaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.onSecondaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.onSecondaryDark
import kr.lul.stringnotebook.state.atom.onSecondaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.onSecondaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onSecondaryLight
import kr.lul.stringnotebook.state.atom.onSecondaryLightHighContrast
import kr.lul.stringnotebook.state.atom.onSecondaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.onSurfaceDark
import kr.lul.stringnotebook.state.atom.onSurfaceDarkHighContrast
import kr.lul.stringnotebook.state.atom.onSurfaceDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onSurfaceLight
import kr.lul.stringnotebook.state.atom.onSurfaceLightHighContrast
import kr.lul.stringnotebook.state.atom.onSurfaceLightMediumContrast
import kr.lul.stringnotebook.state.atom.onSurfaceVariantDark
import kr.lul.stringnotebook.state.atom.onSurfaceVariantDarkHighContrast
import kr.lul.stringnotebook.state.atom.onSurfaceVariantDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onSurfaceVariantLight
import kr.lul.stringnotebook.state.atom.onSurfaceVariantLightHighContrast
import kr.lul.stringnotebook.state.atom.onSurfaceVariantLightMediumContrast
import kr.lul.stringnotebook.state.atom.onTertiaryContainerDark
import kr.lul.stringnotebook.state.atom.onTertiaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.onTertiaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onTertiaryContainerLight
import kr.lul.stringnotebook.state.atom.onTertiaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.onTertiaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.onTertiaryDark
import kr.lul.stringnotebook.state.atom.onTertiaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.onTertiaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.onTertiaryLight
import kr.lul.stringnotebook.state.atom.onTertiaryLightHighContrast
import kr.lul.stringnotebook.state.atom.onTertiaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.outlineDark
import kr.lul.stringnotebook.state.atom.outlineDarkHighContrast
import kr.lul.stringnotebook.state.atom.outlineDarkMediumContrast
import kr.lul.stringnotebook.state.atom.outlineLight
import kr.lul.stringnotebook.state.atom.outlineLightHighContrast
import kr.lul.stringnotebook.state.atom.outlineLightMediumContrast
import kr.lul.stringnotebook.state.atom.outlineVariantDark
import kr.lul.stringnotebook.state.atom.outlineVariantDarkHighContrast
import kr.lul.stringnotebook.state.atom.outlineVariantDarkMediumContrast
import kr.lul.stringnotebook.state.atom.outlineVariantLight
import kr.lul.stringnotebook.state.atom.outlineVariantLightHighContrast
import kr.lul.stringnotebook.state.atom.outlineVariantLightMediumContrast
import kr.lul.stringnotebook.state.atom.primaryContainerDark
import kr.lul.stringnotebook.state.atom.primaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.primaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.primaryContainerLight
import kr.lul.stringnotebook.state.atom.primaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.primaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.primaryDark
import kr.lul.stringnotebook.state.atom.primaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.primaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.primaryLight
import kr.lul.stringnotebook.state.atom.primaryLightHighContrast
import kr.lul.stringnotebook.state.atom.primaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.scrimDark
import kr.lul.stringnotebook.state.atom.scrimDarkHighContrast
import kr.lul.stringnotebook.state.atom.scrimDarkMediumContrast
import kr.lul.stringnotebook.state.atom.scrimLight
import kr.lul.stringnotebook.state.atom.scrimLightHighContrast
import kr.lul.stringnotebook.state.atom.scrimLightMediumContrast
import kr.lul.stringnotebook.state.atom.secondaryContainerDark
import kr.lul.stringnotebook.state.atom.secondaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.secondaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.secondaryContainerLight
import kr.lul.stringnotebook.state.atom.secondaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.secondaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.secondaryDark
import kr.lul.stringnotebook.state.atom.secondaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.secondaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.secondaryLight
import kr.lul.stringnotebook.state.atom.secondaryLightHighContrast
import kr.lul.stringnotebook.state.atom.secondaryLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceBrightDark
import kr.lul.stringnotebook.state.atom.surfaceBrightDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceBrightDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceBrightLight
import kr.lul.stringnotebook.state.atom.surfaceBrightLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceBrightLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerDark
import kr.lul.stringnotebook.state.atom.surfaceContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighDark
import kr.lul.stringnotebook.state.atom.surfaceContainerHighDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighLight
import kr.lul.stringnotebook.state.atom.surfaceContainerHighLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestDark
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestLight
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerHighestLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLight
import kr.lul.stringnotebook.state.atom.surfaceContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowDark
import kr.lul.stringnotebook.state.atom.surfaceContainerLowDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowLight
import kr.lul.stringnotebook.state.atom.surfaceContainerLowLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestDark
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestLight
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceContainerLowestLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceDark
import kr.lul.stringnotebook.state.atom.surfaceDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceDimDark
import kr.lul.stringnotebook.state.atom.surfaceDimDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceDimDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceDimLight
import kr.lul.stringnotebook.state.atom.surfaceDimLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceDimLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceLight
import kr.lul.stringnotebook.state.atom.surfaceLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceLightMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceVariantDark
import kr.lul.stringnotebook.state.atom.surfaceVariantDarkHighContrast
import kr.lul.stringnotebook.state.atom.surfaceVariantDarkMediumContrast
import kr.lul.stringnotebook.state.atom.surfaceVariantLight
import kr.lul.stringnotebook.state.atom.surfaceVariantLightHighContrast
import kr.lul.stringnotebook.state.atom.surfaceVariantLightMediumContrast
import kr.lul.stringnotebook.state.atom.tertiaryContainerDark
import kr.lul.stringnotebook.state.atom.tertiaryContainerDarkHighContrast
import kr.lul.stringnotebook.state.atom.tertiaryContainerDarkMediumContrast
import kr.lul.stringnotebook.state.atom.tertiaryContainerLight
import kr.lul.stringnotebook.state.atom.tertiaryContainerLightHighContrast
import kr.lul.stringnotebook.state.atom.tertiaryContainerLightMediumContrast
import kr.lul.stringnotebook.state.atom.tertiaryDark
import kr.lul.stringnotebook.state.atom.tertiaryDarkHighContrast
import kr.lul.stringnotebook.state.atom.tertiaryDarkMediumContrast
import kr.lul.stringnotebook.state.atom.tertiaryLight
import kr.lul.stringnotebook.state.atom.tertiaryLightHighContrast
import kr.lul.stringnotebook.state.atom.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)


@Composable
fun StringNotebookTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) {
            darkScheme
        } else {
            lightScheme
        },
        typography = AppTypography,
        content = content
    )
}

