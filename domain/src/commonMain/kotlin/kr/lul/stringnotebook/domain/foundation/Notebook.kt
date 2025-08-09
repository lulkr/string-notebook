package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 스트링 노트북.
 */
@ExperimentalUuidApi
interface Notebook {
    /**
     * 고유 식별자.
     */
    val id: Uuid
}