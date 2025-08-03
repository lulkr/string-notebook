package kr.lul.stringnotebook.ui.organism

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.LinkState
import kotlin.uuid.ExperimentalUuidApi

/**
 * 두 오브젝트 사이의 링크를 표시하는 컨테이너.
 */
@ExperimentalUuidApi
@Composable
fun LinkContainer(link: LinkState, context: Context, processor: EventProcessor) {
    Box {
        Link(link, context, processor)
    }
}