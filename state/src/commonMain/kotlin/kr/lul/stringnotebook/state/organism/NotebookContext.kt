package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import kr.lul.stringnotebook.state.template.MenuState

/**
 * 노트북의 편집 컨텍스트.
 */
@Stable
interface NotebookContext {
    object NoOp : NotebookContext {
        override val preferences: NotebookPreferences = NotebookPreferences.NoOp
        override var lock: Boolean = false
        override var active: ObjectState? = null
        override var menu: MenuState? = null
    }

    /**
     * 편집중인 노트북의 설정.
     */
    val preferences: NotebookPreferences

    /**
     * 노트북 자체의 잠금상태. `true`이면 편집이 불가능하다.
     */
    var lock: Boolean

    /**
     * 현재 선택한 객체.
     */
    var active: ObjectState?

    /**
     * 현재 컨텍스트 메뉴 상태.
     */
    var menu: MenuState?
}