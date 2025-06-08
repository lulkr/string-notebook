package kr.lul.stringnotebook.ui.atom

import androidx.compose.runtime.compositionLocalOf
import kr.lul.stringnotebook.domain.foundation.EventProcessor

val LocalEventProcessor = compositionLocalOf<EventProcessor> { EventProcessor.NoOp }