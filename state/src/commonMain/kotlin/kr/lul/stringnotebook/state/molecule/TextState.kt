package kr.lul.stringnotebook.state.molecule

import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import kr.lul.stringnotebook.state.atom.DefaultTextLines
import kr.lul.stringnotebook.state.atom.TextLines
import kr.lul.stringnotebook.state.atom.TextResource
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 텍스트 상태.
 *
 * @property text 텍스트 내용. [resource]가 `null`일 때 사용한다.
 * @property resource 텍스트 리소스. [text]가 `null일` 때 사용한다.
 * @property color 텍스트 색상.
 * @property fontSize 텍스트 크기.
 * @property fontStyle 텍스트 스타일.
 * @property fontWeight 텍스트 굵기.
 * @property fontFamily 텍스트 글꼴.
 * @property letterSpacing 글자 간격.
 * @property textDecoration 텍스트 장식.
 * @property textAlign 텍스트 정렬.
 * @property lineHeight 줄 높이.
 * @property overflow 텍스트 오버플로우 처리 방식.
 * @property softWrap 텍스트 줄 바꿈 여부.
 * @property textLines 텍스트 줄 수. 최대 줄 수를 초과하면 [overflow]에 따라 처리된다.
 * @property inlineContent 인라인 콘텐츠. 특정 위치에 끼워넣을 내용.
 * @property style 텍스트 스타일.
 */
@ExperimentalUuidApi
@Immutable
open class TextState private constructor(
    val text: AnnotatedString? = null,
    val resource: TextResource? = null,
    val color: Color = Color.Companion.Unspecified,
    val fontSize: TextUnit = TextUnit.Companion.Unspecified,
    val fontStyle: FontStyle? = null,
    val fontWeight: FontWeight? = null,
    val fontFamily: FontFamily? = null,
    val letterSpacing: TextUnit = TextUnit.Companion.Unspecified,
    val textDecoration: TextDecoration? = null,
    val textAlign: TextAlign? = null,
    val lineHeight: TextUnit = TextUnit.Companion.Unspecified,
    val overflow: TextOverflow = TextOverflow.Companion.Ellipsis,
    val softWrap: Boolean = true,
    val textLines: TextLines = DefaultTextLines,
    val inlineContent: Map<String, InlineTextContent> = mapOf(),
    val style: TextStyle = TextStyle.Companion.Default,
    override val key: Any = Uuid.Companion.random(),
    override val testTag: String = key.toString()
) : State {
    override val summary = text?.text
        ?: resource?.toString()
        ?: "null"

    constructor(
        text: AnnotatedString,
        color: Color = Color.Companion.Unspecified,
        fontSize: TextUnit = TextUnit.Companion.Unspecified,
        fontStyle: FontStyle? = null,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        letterSpacing: TextUnit = TextUnit.Companion.Unspecified,
        textDecoration: TextDecoration? = null,
        textAlign: TextAlign? = null,
        lineHeight: TextUnit = TextUnit.Companion.Unspecified,
        overflow: TextOverflow = TextOverflow.Companion.Clip,
        softWrap: Boolean = true,
        textLines: TextLines = DefaultTextLines,
        inlineContent: Map<String, InlineTextContent> = mapOf(),
        style: TextStyle = TextStyle.Companion.Default,
        key: Any = Uuid.Companion.random(),
        testTag: String = key.toString()
    ) : this(
        text,
        null,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    constructor(
        text: String,
        color: Color = Color.Companion.Unspecified,
        fontSize: TextUnit = TextUnit.Companion.Unspecified,
        fontStyle: FontStyle? = null,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        letterSpacing: TextUnit = TextUnit.Companion.Unspecified,
        textDecoration: TextDecoration? = null,
        textAlign: TextAlign? = null,
        lineHeight: TextUnit = TextUnit.Companion.Unspecified,
        overflow: TextOverflow = TextOverflow.Companion.Clip,
        softWrap: Boolean = true,
        textLines: TextLines = DefaultTextLines,
        inlineContent: Map<String, InlineTextContent> = mapOf(),
        style: TextStyle = TextStyle.Companion.Default,
        key: Any = Uuid.Companion.random(),
        testTag: String = key.toString()
    ) : this(
        AnnotatedString(text),
        null,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    constructor(
        resource: TextResource,
        color: Color = Color.Companion.Unspecified,
        fontSize: TextUnit = TextUnit.Companion.Unspecified,
        fontStyle: FontStyle? = null,
        fontWeight: FontWeight? = null,
        fontFamily: FontFamily? = null,
        letterSpacing: TextUnit = TextUnit.Companion.Unspecified,
        textDecoration: TextDecoration? = null,
        textAlign: TextAlign? = null,
        lineHeight: TextUnit = TextUnit.Companion.Unspecified,
        overflow: TextOverflow = TextOverflow.Companion.Clip,
        softWrap: Boolean = true,
        textLines: TextLines = DefaultTextLines,
        inlineContent: Map<String, InlineTextContent> = mapOf(),
        style: TextStyle = TextStyle.Companion.Default,
        key: Any = Uuid.Companion.random(),
        testTag: String = key.toString()
    ) : this(
        null,
        resource,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    init {
        require(text != null || resource != null) { "either text or resId must be provided : text=$text, resId=$resource" }
    }

    fun copy(
        text: AnnotatedString,
        color: Color = this.color,
        fontSize: TextUnit = this.fontSize,
        fontStyle: FontStyle? = this.fontStyle,
        fontWeight: FontWeight? = this.fontWeight,
        fontFamily: FontFamily? = this.fontFamily,
        letterSpacing: TextUnit = this.letterSpacing,
        textDecoration: TextDecoration? = this.textDecoration,
        textAlign: TextAlign? = this.textAlign,
        lineHeight: TextUnit = this.lineHeight,
        overflow: TextOverflow = this.overflow,
        softWrap: Boolean = this.softWrap,
        textLines: TextLines = this.textLines,
        inlineContent: Map<String, InlineTextContent> = this.inlineContent,
        style: TextStyle = this.style,
    ) = TextState(
        text,
        null,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    fun copy(
        text: String,
        color: Color = this.color,
        fontSize: TextUnit = this.fontSize,
        fontStyle: FontStyle? = this.fontStyle,
        fontWeight: FontWeight? = this.fontWeight,
        fontFamily: FontFamily? = this.fontFamily,
        letterSpacing: TextUnit = this.letterSpacing,
        textDecoration: TextDecoration? = this.textDecoration,
        textAlign: TextAlign? = this.textAlign,
        lineHeight: TextUnit = this.lineHeight,
        overflow: TextOverflow = this.overflow,
        softWrap: Boolean = this.softWrap,
        textLines: TextLines = this.textLines,
        inlineContent: Map<String, InlineTextContent> = this.inlineContent,
        style: TextStyle = this.style,
    ) = TextState(
        AnnotatedString(text),
        null,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    fun copy(
        resource: TextResource,
        color: Color = this.color,
        fontSize: TextUnit = this.fontSize,
        fontStyle: FontStyle? = this.fontStyle,
        fontWeight: FontWeight? = this.fontWeight,
        fontFamily: FontFamily? = this.fontFamily,
        letterSpacing: TextUnit = this.letterSpacing,
        textDecoration: TextDecoration? = this.textDecoration,
        textAlign: TextAlign? = this.textAlign,
        lineHeight: TextUnit = this.lineHeight,
        overflow: TextOverflow = this.overflow,
        softWrap: Boolean = this.softWrap,
        textLines: TextLines = this.textLines,
        inlineContent: Map<String, InlineTextContent> = this.inlineContent,
        style: TextStyle = this.style,
    ) = TextState(
        null,
        resource,
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign,
        lineHeight,
        overflow,
        softWrap,
        textLines,
        inlineContent,
        style,
        key,
        testTag
    )

    override fun equals(other: Any?) = other === this || (
            other is TextState &&
                    text == other.text &&
                    resource == other.resource &&
                    color == other.color &&
                    fontSize == other.fontSize &&
                    fontStyle == other.fontStyle &&
                    fontWeight == other.fontWeight &&
                    fontFamily == other.fontFamily &&
                    letterSpacing == other.letterSpacing &&
                    textDecoration == other.textDecoration &&
                    textAlign == other.textAlign &&
                    lineHeight == other.lineHeight &&
                    overflow == other.overflow &&
                    softWrap == other.softWrap &&
                    textLines == other.textLines &&
                    inlineContent == other.inlineContent &&
                    style == other.style &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = text?.hashCode() ?: 0
        result = 31 * result + (resource?.hashCode() ?: 0)
        result = 31 * result + color.hashCode()
        result = 31 * result + fontSize.hashCode()
        result = 31 * result + (fontStyle?.hashCode() ?: 0)
        result = 31 * result + (fontWeight?.hashCode() ?: 0)
        result = 31 * result + (fontFamily?.hashCode() ?: 0)
        result = 31 * result + letterSpacing.hashCode()
        result = 31 * result + (textDecoration?.hashCode() ?: 0)
        result = 31 * result + (textAlign?.hashCode() ?: 0)
        result = 31 * result + lineHeight.hashCode()
        result = 31 * result + overflow.hashCode()
        result = 31 * result + softWrap.hashCode()
        result = 31 * result + textLines.hashCode()
        result = 31 * result + inlineContent.hashCode()
        result = 31 * result + style.hashCode()
        result = 31 * result + key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "text=${text?.let { "'$it'" } ?: "null"}",
        "resource=$resource",
        "color=$color",
        "fontSize=$fontSize",
        "fontStyle=$fontStyle",
        "fontWeight=$fontWeight",
        "fontFamily=$fontFamily",
        "letterSpacing=$letterSpacing",
        "textDecoration=$textDecoration",
        "textAlign=$textAlign",
        "lineHeight=$lineHeight",
        "overflow=$overflow",
        "softWrap=$softWrap",
        "textLines=$textLines",
        "inlineContent=$inlineContent",
        "style=$style",
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "TextState(", ")")
}