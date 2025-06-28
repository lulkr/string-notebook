package kr.lul.stringnotebook.viewmodel

import kr.lul.stringnotebook.model.modelModule
import kr.lul.stringnotebook.viewmodel.page.MainPageViewModel
import kr.lul.stringnotebook.viewmodel.page.SplashPageViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
val viewmodelModule = module {
    includes(modelModule)

    viewModel { SplashPageViewModel() }
    viewModel { MainPageViewModel() }
}