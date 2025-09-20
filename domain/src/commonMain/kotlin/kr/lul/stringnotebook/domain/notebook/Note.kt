package kr.lul.stringnotebook.domain.notebook

import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * [Notebook]의 내용을 구성하는 오브젝트.
 */
@ExperimentalTime
@ExperimentalUuidApi
interface Note {
    /**
     * 고유 식별자.
     */
    val id: Uuid

    /**
     * 이름
     */
    var name: String?

    /**
     * 범용 메모.
     */
    var memo: String?

    /**
     * 노트 생성 시각.
     */
    val createdAt: Instant

    /**
     * 마지막 노트 수정 시각.
     */
    val updatedAt: Instant
}