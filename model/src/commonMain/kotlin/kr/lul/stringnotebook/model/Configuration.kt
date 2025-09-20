package kr.lul.stringnotebook.model

import kr.lul.stringnotebook.data.dataModule
import org.koin.dsl.module
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
val modelModule = module {
    includes(dataModule)

    single<NotebookModel> { NotebookModelImpl(get()) }
}