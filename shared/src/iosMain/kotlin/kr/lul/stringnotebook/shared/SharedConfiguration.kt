package kr.lul.stringnotebook.shared

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_PROCESS
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kr.lul.stringnotebook.model.Process
import kr.lul.stringnotebook.navigation.navigationModule

import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
object SharedConfiguration {
    private val logger = Logger("SharedConfiguration")

    fun initialize() {
        logger.i("#initialize called : Configuration=${kr.lul.stringnotebook.domain.foundation.Configuration}")

        val process: Process = object : Process {
            override val startedAt: Instant = Clock.System.now()

            override val id: Uuid = ID_PREFIX_APP_PROCESS.generateId(startedAt.epochSeconds)

            override fun toString() = listOf(
                "id=$id",
                "startedAt=$startedAt"
            ).joinToString(", ", "Process(", ")")
        }
        startKoin {
            modules(module { single { process } }, navigationModule)

            logger.d("#initialize check koin : process=${koin.get<Process>()}")
        }
    }
}
