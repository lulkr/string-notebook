package kr.lul.stringnotebook.ui.organism

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import kr.lul.stringnotebook.state.organism.EditContext
import kotlin.uuid.ExperimentalUuidApi

/**
 * 현재의 [EditContext]를 [Composable] 함수의 인자를 사용하지 않고 전달한다.
 *
 * @see EditContext.Default
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
val LocalEditContext = compositionLocalOf<EditContext> { EditContext.Default }