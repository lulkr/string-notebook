package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북의 상태.
 *
 * 각 상태에 따라 사용할 수 있는 명령이 달라진다.
 */
@ExperimentalUuidApi
@Stable
sealed interface Context {
    /**
     * 노트북의 설정.
     */
    val preferences: NotebookPreferences

    /**
     * 컨텍스트 버전.
     *
     * @see Uuid.random
     */
    val version: Uuid
}

/**
 * 노트북 선택 상태.
 *
 * 오브젝트를 아무것도 선택되지 않은 상태이다. 노트북 메뉴를 열거나 오브젝트를 선택할 수 있다.
 *
 * @property preferences 노트북의 설정.
 * @property version 컨텍스트 버전.
 */
@ExperimentalUuidApi
data class NotebookFocusedContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random()
) : Context {
    /**
     * 노트북 메뉴 상태로 전환한다.
     *
     * @param x 메뉴의 x 좌표.
     * @param y 메뉴의 y 좌표.
     */
    fun menu(x: Float = 0.0F, y: Float = 0.0F) = NotebookMenuContext(
        preferences = preferences,
        version = Uuid.random(),
        x = x,
        y = y
    )

    /**
     * 오브젝트 선택 상태로 전환한다.
     *
     * @param obj 선택한 오브젝트.
     */
    fun focus(obj: ObjectState) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = obj
    )
}

/**
 * 노트북 메뉴 상태.
 *
 * 노트북의 빈 공간을 우클릭 해서 메뉴를 연 상태이다. 메뉴는 새 오브젝트 추가나 노트북 자체를 수정하는 기능을 제공한다.
 * 메뉴를 닫으려면 빈 공간을 클릭하거나 기타 기능을 실행하면 된다.
 *
 * @property preferences 노트북의 설정.
 * @property version 컨텍스트 버전.
 * @property x 메뉴의 x 좌표.
 * @property y 메뉴의 y 좌표.
 */
@ExperimentalUuidApi
data class NotebookMenuContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random(),
    /**
     * 메뉴의 x 좌표.
     */
    val x: Float,
    /**
     * 메뉴의 y 좌표.
     */
    val y: Float
) : Context {
    /**
     * 노트북의 빈 공간 클릭 등의 이유로 중립 상태로 전환한다.
     */
    fun notebook() = NotebookFocusedContext(
        preferences = preferences,
        version = Uuid.random()
    )

    /**
     * 오브젝트 추가 등의 조작으로 오브젝트 선택 상태로 전환한다.
     *
     * @param obj 선택한 오브젝트.
     */
    fun focus(obj: ObjectState) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = obj
    )
}

/**
 * 오브젝트 선택 상태.
 *
 * 특정 오브젝트를 선택한 상태. 특정 오브젝트를 조작하기 위한 기본 상태이다.
 * 오브젝트를 더블 클릭하면 수정 상태로 전환된다. 오브젝트를 우클릭하면 오브젝트 메뉴가 열린다. 빈 공간을 클릭하면 선택이 해제된다.
 * 드래그 & 드랍으로 이동하거나 오브젝트 메뉴를 열 수 있다.
 *
 */
@ExperimentalUuidApi
data class ObjectFocusedContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random(),
    /**
     * 오브젝트 선택 상태.
     */
    val obj: ObjectState
) : Context {
    /**
     * 빈공간 클릭 등의 조작으로 중립 상태로 전환한다.
     */
    fun notebook() = NotebookFocusedContext(
        preferences = preferences,
        version = Uuid.random()
    )

    /**
     * 오브젝트 수정
     *
     * 오브젝트를 수정하는 상태이다. 오브젝트의 내용 등을 변경할 수 있다.
     * 수정이 완료되면 오브젝트 선택 상태로 돌아간다. 빈 공간을 클릭하면 선택이 해제된다.
     */
    fun edit(target: ObjectState = obj) = ObjectEditContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = target
    )

    /**
     * 오브젝트 메뉴
     *
     * 오브젝트의 메뉴를 연 상태이다.
     *
     * 오브젝트를 우클릭하거나 다른 오브젝트에 드랍해서 열 수 있다. 오브젝트 한정 기능이나 기타 기능을 실행할 수 있다.
     *
     * @param x 메뉴의 x 좌표.
     * @param y 메뉴의 y 좌표.
     */
    fun menu(x: Float, y: Float, vararg items: MenuItemState) = ObjectMenuContext(
        preferences = preferences,
        version = Uuid.random(),
        focused = obj,
        x = x,
        y = y,
        items = items.toList()
    )

    /**
     * 오브젝트 미리보기 상태로 전환한다.
     */
    fun preview(target: ObjectState) = ObjectPreviewContext(
        preferences = preferences,
        version = Uuid.random(),
        target = target
    )

    /**
     * 다른 오브젝트를 선택한다.
     */
    fun switch(target: ObjectState) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = target
    )
}

/**
 * 오브젝트 미리보기
 *
 * 오브젝트를 드래그하는 도중의 상태이다.
 * 오브젝트를 빈 공간에 드랍하면 오브젝트의 위치를 옮기고 오브젝트 선택 상태로 돌아간다.
 * 다른 오브젝트에 드랍하면 오브젝트 메뉴가 열린다.
 */
@ExperimentalUuidApi
class ObjectPreviewContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random(),
    /**
     * 미리보기로 보여줄 오브젝트.
     */
    val target: ObjectState
) : Context {
    init {
        require(target !is PreviewState)
    }

    /**
     * 오브젝트를 빈 공간에 드랍하기 등으로 미리보기를 끝내고 오브젝트 선택 상태로 돌아간다.
     */
    fun focus(obj: ObjectState = target) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = obj
    )

    /**
     * 오브젝트 메뉴
     *
     * 오브젝트의 메뉴를 연 상태이다.
     *
     * 오브젝트를 우클릭하거나 다른 오브젝트에 드랍해서 열 수 있다. 오브젝트 한정 기능이나 기타 기능을 실행할 수 있다.
     *
     * @param x 메뉴의 x 좌표.
     * @param y 메뉴의 y 좌표.
     * @param items 메뉴 항목들.
     */
    fun menu(x: Float, y: Float, vararg items: MenuItemState) = menu(x, y, items.toList())

    /**
     * 오브젝트 메뉴
     *
     * 오브젝트의 메뉴를 연 상태이다.
     *
     * 오브젝트를 우클릭하거나 다른 오브젝트에 드랍해서 열 수 있다. 오브젝트 한정 기능이나 기타 기능을 실행할 수 있다.
     *
     * @param x 메뉴의 x 좌표.
     * @param y 메뉴의 y 좌표.
     * @param items 메뉴 항목들.
     */
    fun menu(x: Float, y: Float, items: List<MenuItemState>) = ObjectMenuContext(
        preferences = preferences,
        version = Uuid.random(),
        focused = target,
        x = x,
        y = y,
        items = items
    )
}

/**
 * 오브젝트 메뉴
 *
 * 오브젝트의 메뉴를 연 상태이다.
 * 오브젝트를 우클릭하거나 다른 오브젝트에 드랍해서 열 수 있다. 오브젝트 한정 기능이나 기타 기능을 실행할 수 있다.
 */
@ExperimentalUuidApi
class ObjectMenuContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random(),
    /**
     * 메뉴를 열 오브젝트.
     */
    val focused: ObjectState,
    /**
     * 메뉴의 x 좌표.
     */
    val x: Float,
    /**
     * 메뉴의 y 좌표.
     */
    val y: Float,
    /**
     * 메뉴 항목.
     */
    val items: List<MenuItemState>
) : Context {
    /**
     * 오브젝트 선택 상태로 돌아간다.
     *
     * @param target 선택할 오브젝트.
     */
    fun focus(target: ObjectState = this.focused) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = target
    )

    /**
     * 노트북 선택 상태로 변경한다.
     *
     * 노트북 오브젝트를 아무것도 선택되지 않은 상태이다. 노트북 메뉴를 열거나 오브젝트를 선택할 수 있다.
     */
    fun notebook() = NotebookFocusedContext(
        preferences = preferences,
        version = Uuid.random()
    )
}

/**
 * 오브젝트 수정
 *
 * 오브젝트를 수정하는 상태이다. 오브젝트의 내용 등을 변경할 수 있다.
 * 수정이 완료되면 오브젝트 선택 상태로 돌아간다. 빈 공간을 클릭하면 선택이 해제된다.
 */
@ExperimentalUuidApi
class ObjectEditContext(
    override val preferences: NotebookPreferences = NotebookPreferences.Default,
    override val version: Uuid = Uuid.random(),
    /**
     * 수정할 오브젝트.
     */
    val obj: ObjectState
) : Context {
    /**
     * 다른 오븍젝트 선택 상태로 전환한다.
     *
     * @param target 선택할 오브젝트.
     */
    fun focus(target: ObjectState) = ObjectFocusedContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = target
    )

    /**
     * 노트북 선택 상태로 전환한다.
     */
    fun notebook() = NotebookFocusedContext(
        preferences = preferences,
        version = Uuid.random()
    )

    /**
     * 다른 오브젝트 수정으로 전환한다.
     *
     * @param target 선택할 오브젝트.
     */
    fun edit(target: ObjectState) = ObjectEditContext(
        preferences = preferences,
        version = Uuid.random(),
        obj = target
    )
}