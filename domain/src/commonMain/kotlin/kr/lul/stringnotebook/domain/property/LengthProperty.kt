package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.ScalarProperty
import kr.lul.stringnotebook.domain.type.LengthPropertyType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 길이.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class LengthProperty(
    id: Uuid,
    name: String,
    override var value: Float
) : ScalarProperty<Float>(id, LengthPropertyType, name) {
    constructor(name: String, value: Float) : this(Uuid.random(), name, value)
}