package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.ScalarProperty
import kr.lul.stringnotebook.domain.type.LengthType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
class LengthProperty(
    id: Uuid,
    name: String,
    initValue: Float
) : ScalarProperty<Float>(id, LengthType, name) {
    override var value: Float = initValue
}