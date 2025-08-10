package kr.lul.stringnotebook.domain.property

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.property.LengthPropertyType.ID_POSTFIX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi

@Suppress("NonAsciiCharacters")
@ExperimentalStdlibApi
@ExperimentalUuidApi
class LengthPropertyTypeTest {
    private val logger = Logger("LengthPropertyTypeTest")

    @Test
    fun `StandardPropertyTypes 등록 확인`() {
        // GIVEN
        val type = LengthPropertyType
        logger.i("[GIVEN] type=$type")

        // THEN
        assertEquals(type, StandardPropertyTypes[ID_POSTFIX].type)
        assertEquals(type, StandardPropertyTypes[type].type)
        assertEquals(type, StandardPropertyTypes[type.id].type)
        assertEquals(type, StandardPropertyTypes[type.name].type)
    }
}