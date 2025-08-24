package kr.lul.stringnotebook.state.organism

import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 컨텍스트.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface EditContext {
    /**
     * 앵커 목록.
     */
    val anchors: List<AnchorState>

    /**
     * 모든 노트 목록.
     */
    val notes: List<NoteState>

    /**
     * 우클릭해서 표시할 메뉴.
     */
    val menu: MenuState?
}