package kr.lul.stringnotebook.model

import kr.lul.stringnotebook.data.dataModule
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
val modelModule = module {
    includes(dataModule)

    single<NotebookModel> { NotebookModelImpl(get()) }
}