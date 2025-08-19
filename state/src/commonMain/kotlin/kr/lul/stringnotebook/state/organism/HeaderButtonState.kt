package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kr.lul.stringnotebook.state.molecule.IconState
import kr.lul.stringnotebook.state.molecule.State
import kr.lul.stringnotebook.state.molecule.TextState
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북 목록 헤더 버튼의 상태 홀더.
 *
 * - 디자인 : [ListHeaderButton](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/Untitled?node-id=1-1766)
 */
@ExperimentalUuidApi
@Immutable
data class HeaderButtonState(
    val icon: IconState,
    val label: TextState,
    val enabled: Boolean = true,
    override val key: Any = Uuid.Companion.random(),
    override val testTag: String = key.toString()
) : State