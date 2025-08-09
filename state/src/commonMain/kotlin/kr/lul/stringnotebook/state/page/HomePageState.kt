package kr.lul.stringnotebook.state.page

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.State
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 홈 화면 상태.
 */
@ExperimentalUuidApi
@Immutable
class HomePageState(
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State
