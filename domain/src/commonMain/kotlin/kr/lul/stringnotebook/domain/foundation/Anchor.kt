package kr.lul.stringnotebook.domain.foundation

/**
 * 노트북에 배치할 때 쓸 수 있는 위치정보.
 */
interface Anchor : Object<AnchorType> {
    /**
     * 앵커의 최종 X 좌표.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.X
     */
    var x: Int

    /**
     * 앵커의 최종 Y 좌표.
     *
     * @see kr.lul.stringnotebook.domain.property.StandardPropertyType.Y
     */
    var y: Int

    val summary: String
        get() = "($x, $y)"
}