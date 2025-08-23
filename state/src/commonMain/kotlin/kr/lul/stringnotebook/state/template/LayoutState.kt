package kr.lul.stringnotebook.state.template

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 화면의 레이아웃 상태.
 */
sealed interface LayoutState : State {
    /**
     * 레이아웃 상태 사이클에서 다음 상태.
     */
    val next: LayoutState
}

/**
 * 전체 컴포넌트 표시.
 */
@ExperimentalUuidApi
@Immutable
class FullLayoutState(
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : LayoutState {
    override val summary = "FullLayoutState"
    override val next: LayoutState
        get() = EditorOnlyLayoutState()

    override fun equals(other: Any?) = this === other || (
            other is FullLayoutState &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "FullLayoutState(", ")")
}

/**
 * 편집용 컴포넌트만 표시.
 */
@ExperimentalUuidApi
@Immutable
class EditorOnlyLayoutState(
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : LayoutState {
    override val summary = "EditorOnlyLayoutState"

    override val next: LayoutState
        get() = WyswygLayoutState()

    override fun equals(other: Any?) = this === other || (
            other is EditorOnlyLayoutState &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "EditorOnlyLayoutState(", ")")
}

/**
 * WYSIWYG 노트북 에디터만 표시하는 상태.
 */
@ExperimentalUuidApi
@Immutable
class WyswygLayoutState(
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : LayoutState {
    override val summary = "WyswygLayoutState"

    override val next: LayoutState
        get() = FullLayoutState()

    override fun equals(other: Any?) = this === other || (
            other is WyswygLayoutState &&
                    key == other.key &&
                    testTag == other.testTag
            )

    override fun hashCode(): Int {
        var result = key.hashCode()
        result = 31 * result + testTag.hashCode()
        return result
    }

    override fun toString() = listOf(
        "key=$key",
        "testTag='$testTag'"
    ).joinToString(", ", "WyswygLayoutState(", ")")
}