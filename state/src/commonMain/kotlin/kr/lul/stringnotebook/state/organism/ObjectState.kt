package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 노트북의 내용 객체.
 */
@ExperimentalUuidApi
@Stable
interface ObjectState {
    /**
     * 객체의 고유 식별자.
     */
    val id: Uuid
}