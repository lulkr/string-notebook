package kr.lul.stringnotebook.mcp

import kr.lul.stringnotebook.model.modelModule
import org.koin.dsl.module

fun mcpModule(port: Int = 11_179) = module {
    includes(modelModule)

    single<StringNotebookServer> { StringNotebookServerImpl(port) }
}