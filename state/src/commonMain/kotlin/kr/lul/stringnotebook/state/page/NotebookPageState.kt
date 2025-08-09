package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.organism.notebook.NotebookState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 화면의 상태.
 *
 * @see NotebookPageHandler
 */
sealed interface NotebookPageState : State {
    companion object {
        /**
         * @see kr.lul.stringnotebook.domain.foundation.Notebook.id
         */
        const val ARG_NOTEBOOK_ID = "notebookId"
    }

    /**
     * 노트북 편집 화면을 열고, 노트북을 로드하는 중.
     */
    @ExperimentalUuidApi
    @Immutable
    class Loading(
        val id: Uuid = NotebookState.Placeholder.id,
        override val key: Any = Uuid.random(),
        override val testTag: String = key.toString()
    ) : NotebookPageState {
        fun copy(id: Uuid = this.id) = Loading(
            id = id,
            key = key,
            testTag = testTag
        )

        override fun equals(other: Any?) = this === other || (
                other is Loading &&
                        id == other.id &&
                        key == other.key &&
                        testTag == other.testTag
                )

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + key.hashCode()
            result = 31 * result + testTag.hashCode()
            return result
        }

        override fun toString() = listOf(
            "id=$id",
            "key=$key",
            "testTag=$testTag"
        ).joinToString(", ", "Loading(", ")")
    }

    /**
     * 노트북 편집 화면이 로드되었으며, 노트북 편집이 가능한 상태.
     *
     * @param notebook 로드한 노트북 상태.
     */
    @ExperimentalUuidApi
    @Stable
    class Editing(
        val notebook: NotebookState = NotebookState.Placeholder,
        val componentsMode: ComponentsMode = ComponentsMode.ALL,
        override val key: Any = Uuid.random(),
        override val testTag: String = key.toString()
    ) : NotebookPageState {
        fun copy(
            notebook: NotebookState = this.notebook,
            componentsMode: ComponentsMode = this.componentsMode,
        ) = Editing(
            notebook = notebook,
            componentsMode = componentsMode,
            key = key,
            testTag = testTag
        )

        override fun equals(other: Any?) = this === other || (
                other is Editing &&
                        notebook == other.notebook &&
                        componentsMode == other.componentsMode &&
                        key == other.key &&
                        testTag == other.testTag
                )

        override fun hashCode(): Int {
            var result = notebook.hashCode()
            result = 31 * result + componentsMode.hashCode()
            result = 31 * result + key.hashCode()
            result = 31 * result + testTag.hashCode()
            return result
        }

        override fun toString() = listOf(
            "notebook=$notebook",
            "componentsMode=$componentsMode",
            "key=$key",
            "testTag=$testTag"
        ).joinToString(", ", "Editing(", ")")
    }
}

/**
 * 화면에 표시할 컴포넌트 모드.
 */
enum class ComponentsMode {
    /**
     * 모두 표시.
     */
    ALL,

    /**
     * 오버레이(노트북 요약, 노트 툴바) 숨기기.
     */
    HIDE_OVERLAY,

    /**
     * [HIDE_OVERLAY]에 추가로 속성 에디터도 숨기고 WYSWYG 편집기만 표시.
     */
    NOTEBOOK_ONLY
}