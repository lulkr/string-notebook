package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.template.FullLayoutState
import kr.lul.stringnotebook.state.template.LayoutState
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
    @ExperimentalStdlibApi
    @ExperimentalUuidApi
    @Immutable
    class Loading(
        val id: Uuid = NotebookState.Placeholder.id,
        override val key: Any = Uuid.random(),
        override val testTag: String = key.toString()
    ) : NotebookPageState {
        override val summary = "NotebookPageState.Loading"

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
    @ExperimentalStdlibApi
    @ExperimentalUuidApi
    @Stable
    class Editing(
        val notebook: NotebookState = NotebookState.Placeholder,
        val layout: LayoutState = FullLayoutState(),
        override val key: Any = Uuid.random(),
        override val testTag: String = key.toString()
    ) : NotebookPageState {
        override val summary = "NotebookPageState.Editing(notebook=${notebook.summary}, layout=${layout.summary})"

        fun copy(
            notebook: NotebookState = this.notebook,
            layout: LayoutState = this.layout,
        ) = Editing(
            notebook = notebook,
            layout = layout,
            key = key,
            testTag = testTag
        )

        override fun equals(other: Any?) = this === other || (
                other is Editing &&
                        notebook == other.notebook &&
                        layout == other.layout &&
                        key == other.key &&
                        testTag == other.testTag
                )

        override fun hashCode(): Int {
            var result = notebook.hashCode()
            result = 31 * result + layout.hashCode()
            result = 31 * result + key.hashCode()
            result = 31 * result + testTag.hashCode()
            return result
        }

        override fun toString() = listOf(
            "notebook=$notebook",
            "layout=$layout",
            "key=$key",
            "testTag=$testTag"
        ).joinToString(", ", "Editing(", ")")
    }
}