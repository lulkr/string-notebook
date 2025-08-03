package kr.lul.stringnotebook.state.molecule

import androidx.compose.runtime.Immutable

/**
 * 줄 수.
 */
sealed interface TextLines {
    /**
     * 최소 줄 수.
     */
    val min: Int

    /**
     * 최대 줄 수.
     */
    val max: Int

    val singleLine: Boolean
}

/**
 * 기본값. 1줄 ~ [Int.MAX_VALUE]줄.
 */
@Immutable
data object DefaultTextLines : TextLines {
    override val min: Int = 1
    override val max: Int = Int.MAX_VALUE
    override val singleLine: Boolean = false
    override fun toString() = "DefaultTextLines(min=$min, max=$max)"
}

/**
 * 1줄.
 */
@Immutable
data object SingleTextLine : TextLines {
    override val min = 1
    override val max = 1
    override val singleLine = true
    override fun toString() = "SingleTextLine"
}

/**
 * [DefaultTextLines]와 [SingleTextLine]을 제외한 여러 줄.
 *
 * @see DefaultTextLines
 * @see SingleTextLine
 */
@Immutable
data class MultiTextLines(
    override val min: Int = 1,
    override val max: Int = Int.MAX_VALUE
) : TextLines {
    override val singleLine = false

    init {
        require(1 <= min) { "min must be greater than or equal to 1 : min=$min" }
        require(min <= max) { "max must be greater than or equal to min : min=$min, max=$max" }
        require(!(1 == min && 1 == max)) { "use SingleTextLine instead." }
        require(!(1 == min && Int.MAX_VALUE == max)) { "use DefaultTextLines instead." }
    }

    override fun toString() = "MultiTextLines(min=$min, max=$max)"
}

/**
 * 줄 수를 지정하여 [TextLines]를 생성한다.
 *
 * @param lines 줄 수.
 */
fun TextLines(lines: Int): TextLines = when (lines) {
    1 -> SingleTextLine
    else -> MultiTextLines(lines, lines)
}

/**
 * 최소, 최대 줄 수를 지정하여 [TextLines]를 생성한다.
 *
 * @param min 최소 줄 수.
 * @param max 최대 줄 수.
 */
fun TextLines(min: Int, max: Int): TextLines = when {
    1 == min && 1 == max -> SingleTextLine
    1 == min && Int.MAX_VALUE == max -> DefaultTextLines
    else -> MultiTextLines(min, max)
}