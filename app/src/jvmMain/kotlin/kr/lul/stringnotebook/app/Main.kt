package kr.lul.stringnotebook.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.logger.d
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_PROCESS
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kr.lul.stringnotebook.mcp.StringNotebookServer
import kr.lul.stringnotebook.mcp.mcpModule
import kr.lul.stringnotebook.model.Process
import kr.lul.stringnotebook.navigation.Root
import kr.lul.stringnotebook.navigation.compose.rememberBaseNavigator
import kr.lul.stringnotebook.navigation.navigationModule
import kr.lul.stringnotebook.navigation.navigator.SplashNavigator
import org.koin.core.context.startKoin
import org.koin.dsl.module
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalUuidApi
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val logger = Logger("main")
    val process: Process = object : Process {
        override val startedAt: Instant = Clock.System.now()

        override val id: Uuid = ID_PREFIX_APP_PROCESS.generateId(startedAt.epochSeconds)

        override fun toString() = listOf(
            "id=$id",
            "startedAt=$startedAt"
        ).joinToString(", ", "Process(", ")")
    }

    application {
        startKoin {
            modules(
                module {
                    single { process }
                },
                mcpModule(),
                navigationModule
            )
            logger.d { "#main check koin : process=${koin.get<Process>()}" }

            val mcp = koin.get<StringNotebookServer>()
            mcp.start()
        }

        Window(
            onCloseRequest = ::exitApplication,
            title = "String Notebook",
        ) {
            Root(rememberBaseNavigator(SplashNavigator))
        }
    }
}
