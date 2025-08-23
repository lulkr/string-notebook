package kr.lul.stringnotebook.state.organism

import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 컨텍스트.
 */
@ExperimentalUuidApi
interface EditContext {
    /**
     * 우클릭해서 표시할 메뉴.
     */
    val menu: List<MenuItem>
}