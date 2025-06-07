package kr.lul.stringnotebook.domain.foundation

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * String Notebook
 */
@OptIn(ExperimentalUuidApi::class)
interface StringNotebook {
    /**
     * 노트북 ID.
     */
    val id: Uuid

    /**
     * 노트북 이름.
     *
     * 노트북의 이름은 사용자가 지정할 수 있으며, 기본값은 "새 노트북"이다.
     */
    var name: String

    /**
     * 노트북의 오브젝트 목록.
     */
    val objects: List<Object<*>>

    /**
     * 노트북의 앵커 목록.
     */
    val anchors: List<Anchor>

    /**
     * 노트북의 오브젝트를 반환한다.
     *
     * @param id [Object.id]
     */
    operator fun get(id: Uuid): Object<*>

    /**
     * 노트북에서 오브젝트를 제거합니다.
     *
     * @param id [Object.id]
     *
     * @return 제거된 오브젝트
     */
    fun remove(id: Uuid): Object<*>

    /**
     * 노트북에 앵커를 추가합니다.
     *
     * @param anchor 추가할 앵커
     */
    fun add(anchor: Anchor)

    /**
     * 노트북에서 앵커를 제거합니다.
     *
     * @param anchor 제거할 앵커
     */
    fun remove(anchor: Anchor)
}