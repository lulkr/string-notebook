package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Immutable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * @see kr.lul.stringnotebook.domain.foundation.Anchor
 */
@Immutable
@OptIn(ExperimentalUuidApi::class)
data class AnchorState(
    /**
     * @see kr.lul.stringnotebook.domain.foundation.Anchor.id
     */
    val id: Uuid = Uuid.random(),
    /**
     * @see kr.lul.stringnotebook.domain.foundation.Anchor.x
     */
    val x: Int = 0,
    /**
     * @see kr.lul.stringnotebook.domain.foundation.Anchor.y
     */
    val y: Int = 0
)
