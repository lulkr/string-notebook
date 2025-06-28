package kr.lul.stringnotebook.viewmodel.atom

import kotlin.uuid.ExperimentalUuidApi

/**
 * [BaseViewModel]이 해당 화면에 속한 UI 컴포넌트의 소유자임을 나타내며, 소속 [BaseViewModelet]을 통제하는 인터페이스입니다.
 */
@ExperimentalUuidApi
interface ViewModeletOwner {
    /**
     * 페이지를 관리하는 [BaseViewModel]을 반환합니다.
     */
    val root: BaseViewModel
        get() = if (this is BaseViewModel && null == parent) {
            this
        } else {
            parent!!.root
        }

    /**
     * 현재 [ViewModeletOwner]의 부모 [ViewModeletOwner]을 반환합니다.
     *
     * `this === root`인 경우 `null`을 반환합니다.
     *
     * @see root
     */
    val parent: ViewModeletOwner?

    /**
     * 등록된 [BaseViewModelet]의 목록.
     */
    val children: Set<BaseViewModelet>

    /**
     * [BaseViewModelet]을 등록합니다.
     *
     * **주의** : [BaseViewModelet]이 `init` 블럭에서 자신을 등록하기 위해 호출해야 하기 때문에,
     * 호출 당시에는 `viewModelet`인자가 초기화가 끝나지 않은 상태이다.
     * 따라서 `viewModelet`의 속성에 접근하는 것은 위험할 수 있다.
     *
     * @param viewModelet 등록할 [BaseViewModelet].
     */
    fun register(viewModelet: BaseViewModelet)
}