package kr.lul.stringnotebook.state.molecule

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 편집 컨텍스트.
 */
@OptIn(ExperimentalUuidApi::class)
interface NotebookEditContext {
    object NoOp : NotebookEditContext {
        override var focused: Uuid? = null
    }

    /**
     * 포커스를 가진 [kr.lul.stringnotebook.domain.foundation.Object]의 ID. 없으면 `null`.
     *
     * @see kr.lul.stringnotebook.domain.foundation.Object.id
     */
    val focused: Uuid?
}