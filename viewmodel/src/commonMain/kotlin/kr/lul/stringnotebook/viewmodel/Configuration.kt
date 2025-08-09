package kr.lul.stringnotebook.viewmodel

import androidx.lifecycle.SavedStateHandle
import kr.lul.stringnotebook.model.modelModule
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.state.page.NotebookPageState.Companion.ARG_NOTEBOOK_ID
import kr.lul.stringnotebook.viewmodel.page.HomePageViewModel
import kr.lul.stringnotebook.viewmodel.page.NotebookPageViewModel
import kr.lul.stringnotebook.viewmodel.page.SplashPageViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
val viewmodelModule = module {
    includes(modelModule)

    viewModel { SplashPageViewModel() }

    //-----------------------------------------------------------------------------------------------------------------

    viewModel { HomePageViewModel(get()) }
    viewModel {
        val handle: SavedStateHandle = get()
        NotebookPageViewModel(
            initState = NotebookPageState.Loading(Uuid.parse(requireNotNull(handle[ARG_NOTEBOOK_ID])))
        )
    }
}