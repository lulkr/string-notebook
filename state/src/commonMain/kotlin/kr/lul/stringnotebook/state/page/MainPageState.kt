package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NeutralContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 메인 페이지 상태.
 *
 * @property welcome 환영 메시지
 */
@ExperimentalUuidApi
@Immutable
data class MainPageState(
    val notebook: NotebookState = NotebookState(),
    val context: Context = NeutralContext(),
    val processor: EventProcessor = EventProcessor.NoOp
)
