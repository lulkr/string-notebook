package kr.lul.stringnotebook.domain.notebook

import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.property.ColorProperty
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 스트링 노트북.
 *
 * TODO UI 속성 추가.
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
    var name: String

    /**
     * 간단한 설명을 포함한 메모.
     */
    var memo: String?

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
     * 기본 앵커 컨테이너의 테두리.
     */
    val anchorContainerBorder: Border?

    /**
     * 기본 앵커 컨테이너의 배경색.
     */
    val anchorContainerBackground: ColorProperty?

    /**
     * 생성 시각.
     */
    val createdAt: Instant

    /**
     * 마지막 수정 시각.
     */
    val updatedAt: Instant

    /**
     * 앵커 추가.
     *
     * @param anchor 추가할 앵커.
     * @return 정상적으로 추가하면 `true`.
     */
    fun add(anchor: Anchor): Boolean
}