package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_NOTEBOOK_PROPERTY
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
) : ScalarProperty<Float>(id, LengthPropertyType, name) {
    companion object {
        val Unspecified = LengthProperty(id = Uuid.parse("$ID_PREFIX_NOTEBOOK_PROPERTY-000000000000"))
    }
}