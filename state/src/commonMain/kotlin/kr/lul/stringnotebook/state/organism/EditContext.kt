package kr.lul.stringnotebook.state.organism

import kotlin.uuid.ExperimentalUuidApi

/**
 * 노트북 편집 컨텍스트.
 *
 * 노트북의 하위 UI 컴포넌트가 노트북 편집에 필요한 상태를 제공한다.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface EditContext {
    /**
     * 기본 구현. 빈 상태.
     */
    object Default : EditContext {
        override val anchors: List<AnchorState> = emptyList()
        override val notes: List<NoteState> = emptyList()
        override val menu: MenuState? = null
    }

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