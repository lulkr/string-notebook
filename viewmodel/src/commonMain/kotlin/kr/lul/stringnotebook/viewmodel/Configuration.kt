package kr.lul.stringnotebook.viewmodel

import kr.lul.stringnotebook.model.modelModule
import kr.lul.stringnotebook.viewmodel.page.MainViewModel
import kr.lul.stringnotebook.viewmodel.page.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
val viewmodelModule = module {
    includes(modelModule)

    viewModel { SplashViewModel() }
    viewModel { MainViewModel() }
}