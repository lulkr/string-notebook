package kr.lul.stringnotebook.state.atom

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.IntSize

val Size.summary: String
    get() = "($width x $height)"

fun Size.toDp(density: Density): Size {
    val width = with(density) { width.toDp().value }
    val height = with(density) { height.toDp().value }

    return Size(width, height)
}

/**
 * @param diff 차이.
 */
operator fun Size.minus(diff: Offset) = copy(width - diff.x, height - diff.y)

/**
 * @param diff 차이.
 */
operator fun Size.plus(diff: Offset) = copy(width + diff.x, height + diff.y)

fun IntSize.toDp(density: Density): Size {
    val width = with(density) { width.toDp().value }
    val height = with(density) { height.toDp().value }

    return Size(width, height)
}