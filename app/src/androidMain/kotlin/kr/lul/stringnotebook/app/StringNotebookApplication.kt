package kr.lul.stringnotebook.app

import android.app.Application
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Configuration
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_PROCESS
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kr.lul.stringnotebook.model.Build
import kr.lul.stringnotebook.model.Process
import kr.lul.stringnotebook.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
class StringNotebookApplication : Application() {
    private val logger = Logger("StringNotebookApplication")

    private val process: Process = object : Process {
        override val startedAt: Instant = Clock.System.now()

        override val id: Uuid = ID_PREFIX_APP_PROCESS.generateId(startedAt.epochSeconds)

        override fun toString() = listOf(
            "id=$id",
            "startedAt=$startedAt"
        ).joinToString(", ", "Process(", ")")
    }

    override fun onCreate() {
        logger.i("#onCreate called : Configuration=${Configuration}")
        super.onCreate()

        startKoin {
            logger.i("#onCreate start ${Configuration.NAME} ${Configuration.VERSION} : build=${Build}")
            androidContext(this@StringNotebookApplication)
            modules(
                module {
                    single { this@StringNotebookApplication.process }
                },
                navigationModule
            )
        }
    }
}