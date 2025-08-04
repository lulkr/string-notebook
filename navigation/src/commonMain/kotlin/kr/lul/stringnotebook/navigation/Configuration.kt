package kr.lul.stringnotebook.navigation

import kr.lul.logger.Logger
import kr.lul.stringnotebook.viewmodel.viewmodelModule
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi

internal val logger = Logger("ui")

@ExperimentalStdlibApi
@ExperimentalUuidApi
val navigationModule = module {
    includes(viewmodelModule)
}