package kr.lul.stringnotebook.viewmodel.atom

import androidx.annotation.CallSuper
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kr.lul.logger.Logger
import kotlin.uuid.ExperimentalUuidApi

/**
 * UI 컴포넌트를 관리하는 [DefaultLifecycleObserver]의 기본 클래스.
 *
 * 페이지 단위의 [androidx.lifecycle.ViewModel]의 일부 기능을 위임받는다.
 */
@ExperimentalUuidApi
open class BaseViewModelet(
    override val parent: ViewModeletOwner,
    protected val tag: String
) : ViewModeletOwner, DefaultLifecycleObserver {
    protected val logger = Logger(tag)

    private val _children = mutableSetOf<BaseViewModelet>()
    override val children: Set<BaseViewModelet> = _children

    init {
        if (tag.isBlank()) {
            throw IllegalArgumentException("tag must not be blank.")
        }

        @Suppress("LeakingThis")
        parent.register(this)
    }

    override fun register(viewModelet: BaseViewModelet) {
        logger.v("#register args : viewModelet=$viewModelet")
        require(!_children.contains(viewModelet)) {
            "viewModelet must not be already registered : owner=$this, viewModelet=$viewModelet"
        }

        _children.add(viewModelet)
    }

    @CallSuper
    override fun onCreate(owner: LifecycleOwner) {
        logger.d("#onCreate args : owner=$owner")

        for (child in _children) {
            child.onCreate(owner)
        }
    }

    @CallSuper
    override fun onStart(owner: LifecycleOwner) {
        logger.d("#onStart args : owner=$owner")

        for (child in _children) {
            child.onStart(owner)
        }
    }

    @CallSuper
    override fun onResume(owner: LifecycleOwner) {
        logger.v("#onResume args : owner=$owner")

        for (child in _children) {
            child.onResume(owner)
        }
    }

    @CallSuper
    override fun onPause(owner: LifecycleOwner) {
        logger.v("#onPause args : owner=$owner")

        for (child in _children) {
            child.onPause(owner)
        }
    }

    @CallSuper
    override fun onStop(owner: LifecycleOwner) {
        logger.d("#onStop args : owner=$owner")

        for (child in _children) {
            child.onStop(owner)
        }
    }

    @CallSuper
    override fun onDestroy(owner: LifecycleOwner) {
        logger.d("#onDestroy args : owner=$owner")

        for (child in _children) {
            child.onDestroy(owner)
        }
    }

    @CallSuper
    open fun onCleared() {
        logger.d("#onCleared called.")

        for (child in _children) {
            child.onCleared()
        }
    }
}