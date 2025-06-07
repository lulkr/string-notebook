package kr.lul.stringnotebook.domain.anchor

import kr.lul.stringnotebook.domain.foundation.AnchorType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 기본 앵컥 종류.
 */
@OptIn(ExperimentalUuidApi::class)
enum class StandardAnchorType(
    override val id: Uuid,
    override val label: String,
    override val description: String
) : AnchorType {
    ABSOLUTE(1, "absolute", "절대 위치 앵커. 노트북 워크스페이스의 원점을 기준으로 위치를 지정합니다."),
    RELATIVE(2, "relative", "상대 위치 앵커. 다른 앵커를 기준으로 위치를 지정합니다.");

    constructor(id: Int, label: String, description: String) : this(AnchorType.id(id), label, description)
}