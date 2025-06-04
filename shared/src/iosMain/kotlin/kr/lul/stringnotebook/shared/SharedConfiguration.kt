package kr.lul.stringnotebook.shared

import kr.lul.stringnotebook.navigation.navigationModule

import org.koin.core.context.startKoin

object SharedConfiguration {
    fun initialize() {
        startKoin {
            modules(navigationModule)
        }
    }
}
