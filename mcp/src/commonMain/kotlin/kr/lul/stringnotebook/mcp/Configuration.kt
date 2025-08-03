package kr.lul.stringnotebook.mcp

import kr.lul.stringnotebook.model.modelModule
import org.koin.dsl.module

fun mcpModule(port: Int = 11179) = module {
    includes(modelModule)
}