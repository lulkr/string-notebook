package kr.lul.stringnotebook.viewmodel.atom

import androidx.annotation.CallSuper
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kr.lul.logger.Logger
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.cancellation.CancellationException
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 페이지 레이어의 상태를 관리하는 [ViewModel]의 기본 클래스.
 *
 * @property tag 로깅에 사용되는 태그.
 */
@ExperimentalUuidApi
open class BaseViewModel(
    protected val tag: String
) : ViewModel(), DefaultLifecycleObserver {
    protected val logger = Logger(tag)

    init {
        if (tag.isBlank()) {
            throw IllegalArgumentException("tag must not be blank.")
        }
    }

    /**
     * [viewModelScope]의 코루틴을 실행한다.
     *
     * @param key 코루틴 실행을 구분하기 위한 식별자. 호출할 때마다 다른 값을 사용해야 한다.
     * @param context 코루틴 실행 컨텍스트.
     * @param start 코루틴 시작 옵션.
     * @param block 실행할 코루틴 블록.
     *
     * @return 실행 결과를 담은 [Job].
     */
    protected fun launch(
        key: Any = Uuid.random(),
        context: CoroutineContext = EmptyCoroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        logger.v("#launch args : key=$key, context=$context, start=$start, block=$block")

        val job = viewModelScope.launch(context, start, block)
        job.invokeOnCompletion { e ->
            if (null != e && e !is CancellationException) {
                logger.w("#launch error : key=$key", e)
            }
        }

        logger.v("#launch return : $job")
        return job
    }

    @CallSuper
    override fun onCreate(owner: LifecycleOwner) {
        logger.d("#onCreate args : owner=$owner")
        super.onCreate(owner)
    }

    @CallSuper
    override fun onStart(owner: LifecycleOwner) {
        logger.d("#onStart args : owner=$owner")
        super.onStart(owner)
    }

    @CallSuper
    override fun onResume(owner: LifecycleOwner) {
        logger.d("#onResume args : owner=$owner")
        super.onResume(owner)
    }

    @CallSuper
    override fun onPause(owner: LifecycleOwner) {
        logger.d("#onPause args : owner=$owner")
        super.onPause(owner)
    }

    @CallSuper
    override fun onStop(owner: LifecycleOwner) {
        logger.d("#onStop args : owner=$owner")
        super.onStop(owner)
    }

    @CallSuper
    override fun onDestroy(owner: LifecycleOwner) {
        logger.d("#onDestroy args : owner=$owner")
        super.onDestroy(owner)
    }

    @CallSuper
    override fun onCleared() {
        logger.d("#onCleared called.")
        super.onCleared()
    }
}