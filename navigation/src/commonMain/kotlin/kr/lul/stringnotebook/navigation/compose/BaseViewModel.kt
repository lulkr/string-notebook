package kr.lul.stringnotebook.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import kr.lul.stringnotebook.viewmodel.atom.BaseViewModel
import org.koin.compose.currentKoinScope
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope
import org.koin.viewmodel.defaultExtras
import kotlin.uuid.ExperimentalUuidApi

/**
 * [koinViewModel]을 확장해서 [BaseViewModel]을 상속한 VM을 생성하고, 라이프사이클 관리에 등록한다.
 *
 * @param VM 생성할 ViewModel의 타입.
 * @param qualifier Koin에서 ViewModel을 구분하기 위한 선택적 [Qualifier].
 * @param viewModelStoreOwner ViewModel을 저장할 [ViewModelStoreOwner]. 기본값은 현재 컴포저블의 [LocalViewModelStoreOwner]에서 가져온다.
 */
@Composable
@ExperimentalUuidApi
inline fun <reified VM : BaseViewModel> baseViewModel(
    qualifier: Qualifier? = null,
    viewModelStoreOwner: ViewModelStoreOwner = LocalViewModelStoreOwner.current
        ?: error("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"),
    key: String? = null,
    extras: CreationExtras = defaultExtras(viewModelStoreOwner),
    scope: Scope = currentKoinScope(),
    noinline parameters: ParametersDefinition? = null
): VM {
    val viewModel: VM = koinViewModel(qualifier, viewModelStoreOwner, key, extras, scope, parameters)
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(viewModel) {
        lifecycleOwner.lifecycle.addObserver(viewModel)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(viewModel)
        }
    }

    return viewModel
}