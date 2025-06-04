package kr.lul.stringnotebook.app

import android.app.Application
import kr.lul.logger.Logger
import kr.lul.logger.i
import kr.lul.stringnotebook.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StringNotebookApplication : Application() {
    private val logger = Logger("StringNotebookApplication")

    override fun onCreate() {
        logger.i { "#onCreated called." }
        super.onCreate()

        startKoin {
            androidContext(this@StringNotebookApplication)
            modules(navigationModule)
        }
    }
}