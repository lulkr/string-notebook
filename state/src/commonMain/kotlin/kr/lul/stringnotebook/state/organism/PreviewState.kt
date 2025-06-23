package kr.lul.stringnotebook.state.organism

import kotlin.uuid.ExperimentalUuidApi

/**
 * 오브젝트의 미리보기 상태.
 */
@ExperimentalUuidApi
interface PreviewState : ObjectState {
    /**
     * 미리보기 할 오브젝트.
     */
    val obj: ObjectState

    /**
     * 미리보기의 x 좌표.
     */
    var x: Float

    /**
     * 미리보기의 y 좌표.
     */
    var y: Float
}