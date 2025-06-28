package kr.lul.stringnotebook.viewmodel.atom

import kotlin.uuid.ExperimentalUuidApi

/**
 * [BaseViewModel]이 해당 화면에 속한 UI 컴포넌트의 소유자임을 나타내며, 소속 [BaseViewModelet]을 통제하는 인터페이스입니다.
 */
@ExperimentalUuidApi
interface ViewModeletOwner {
    /**
     * 등록된 [BaseViewModelet]의 목록.
     */
    val children: Set<BaseViewModelet>

    /**
     * [BaseViewModelet]을 등록합니다.
     *
     * @param viewModelet 등록할 [BaseViewModelet].
     */
    fun register(viewModelet: BaseViewModelet)
}