package kr.lul.stringnotebook.navigation

import kr.lul.logger.Logger
import kr.lul.stringnotebook.viewmodel.viewmodelModule
import org.koin.dsl.module

internal val logger = Logger("ui")

val navigationModule = module {
    includes(viewmodelModule)
}