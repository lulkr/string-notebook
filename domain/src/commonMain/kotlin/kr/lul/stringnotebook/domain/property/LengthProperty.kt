package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.Property
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
    id: Uuid = Property.id(),
    name: String? = null,
    override var value: Float = 0F
) : ScalarProperty<Float>(id, LengthPropertyType, name)