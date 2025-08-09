package kr.lul.stringnotebook.data

import kr.lul.stringnotebook.data.repository.NotebookRepository
import kr.lul.stringnotebook.data.repository.NotebookRepositoryImpl
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
val dataModule = module {
    single<NotebookRepository> { NotebookRepositoryImpl() }
}