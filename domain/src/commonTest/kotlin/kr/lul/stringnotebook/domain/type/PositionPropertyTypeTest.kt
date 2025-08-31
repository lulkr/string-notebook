package kr.lul.stringnotebook.domain.type

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.PositionPropertyType.ID_SUFFIX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class PositionPropertyTypeTest {
    private val logger = Logger("PositionPropertyTypeTest")

    @Test
    fun `StandardPropertyTypes 등록 확인`() {
        // GIVEN
        val type = PositionPropertyType
        logger.i("[GIVEN] type=$type")

        // THEN
        assertEquals(type, StandardPropertyTypes[ID_SUFFIX].type)
        assertEquals(type, StandardPropertyTypes[type].type)
        assertEquals(type, StandardPropertyTypes[type.id].type)
        assertEquals(type, StandardPropertyTypes[type.name].type)
        assertTrue(type.properties.keys.contains(type.PROP_X))
        assertTrue(type.properties.keys.contains(type.PROP_Y))
    }
}