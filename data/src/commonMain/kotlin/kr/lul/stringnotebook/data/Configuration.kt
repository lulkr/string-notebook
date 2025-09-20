package kr.lul.stringnotebook.data

import kr.lul.stringnotebook.data.repository.NotebookRepository
import kr.lul.stringnotebook.data.repository.NotebookRepositoryImpl
import org.koin.dsl.module
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
val dataModule = module {
    single<NotebookRepository> { NotebookRepositoryImpl() }
}