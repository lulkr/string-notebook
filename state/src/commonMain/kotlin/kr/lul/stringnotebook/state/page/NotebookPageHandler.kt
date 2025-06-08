package kr.lul.stringnotebook.state.page

import kr.lul.stringnotebook.domain.foundation.EventProcessor

/**
 * @see NotebookPageState
 */
interface NotebookPageHandler {
    object NoOp : NotebookPageHandler {
        override val notebook = EventProcessor.NoOp
    }

    val notebook: EventProcessor
}