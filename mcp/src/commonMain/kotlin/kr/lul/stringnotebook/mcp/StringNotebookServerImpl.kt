package kr.lul.stringnotebook.mcp

import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.modelcontextprotocol.kotlin.sdk.CallToolResult
import io.modelcontextprotocol.kotlin.sdk.Implementation
import io.modelcontextprotocol.kotlin.sdk.ServerCapabilities
import io.modelcontextprotocol.kotlin.sdk.TextContent
import io.modelcontextprotocol.kotlin.sdk.Tool
import io.modelcontextprotocol.kotlin.sdk.server.Server
import io.modelcontextprotocol.kotlin.sdk.server.ServerOptions
import io.modelcontextprotocol.kotlin.sdk.server.mcp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.serialization.json.JsonObject
import kr.lul.logger.Logger

class StringNotebookServerImpl(
    val port: Int,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
) : StringNotebookServer {
    private val logger = Logger("StringNotebookServerImpl")

    private val server: Server

    init {
        logger.i("#init : port=$port")
        require((1024..65535).contains(port)) { "port number must be between 1024 and 65535 : port=$port" }

        server = Server(
            Implementation(name = "StringNotebookServer", version = "1.0.0"),
            ServerOptions(capabilities = ServerCapabilities(tools = ServerCapabilities.Tools(listChanged = true)))
        )
        server.addTool(
            Tool(
                name = "objects",
                description = "노트북의 오브젝트 목록을 반환한다.",
                inputSchema = Tool.Input(),
                outputSchema = Tool.Output(JsonObject(emptyMap())),
                annotations = null
            )
        ) { request ->
            CallToolResult(content = listOf(TextContent("dummy `objects` response.")))
        }
    }

    override fun start() {
        logger.i("#start called.")

        embeddedServer(CIO, port) {
            mcp { server }
        }.start(wait = true)
    }

    override fun stop() {
        logger.i("#stop called.")
    }
}