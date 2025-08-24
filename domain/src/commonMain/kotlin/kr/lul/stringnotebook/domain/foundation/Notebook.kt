package kr.lul.stringnotebook.domain.foundation

import kotlinx.datetime.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 스트링 노트북.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
interface Notebook {
    /**
     * 고유 식별자.
     */
    val id: Uuid

    /**
     * 이름.
     */
    val name: String

    /**
     * 간단한 설명을 포함한 메모.
     */
    val memo: String?

    /**
     * 노트 목록.
     *
     * @see anchors
     */
    val notes: List<Note>
        get() = anchors

    /**
     * 앵커 목록.
     */
    val anchors: List<Anchor>

    /**
     * 생성 시각.
     */
    val createdAt: Instant

    /**
     * 마지막 수정 시각.
     */
    val updatedAt: Instant
}