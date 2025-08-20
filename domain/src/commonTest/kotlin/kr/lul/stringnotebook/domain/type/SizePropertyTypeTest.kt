package kr.lul.stringnotebook.domain.type

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.SizePropertyType.ID_SUFFIX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class SizePropertyTypeTest {
    private val logger = Logger("SizePropertyTypeTest")

    @Test
    fun `StandardPropertyTypes 등록 확인`() {
        // GIVEN
        val type = SizePropertyType
        logger.i("[GIVEN] type=$type")

        // THEN
        assertEquals(type, StandardPropertyTypes[ID_SUFFIX].type)
        assertEquals(type, StandardPropertyTypes[type].type)
        assertEquals(type, StandardPropertyTypes[type.id].type)
        assertEquals(type, StandardPropertyTypes[type.name].type)
        assertTrue(type.properties.keys.contains(type.WIDTH))
        assertTrue(type.properties.keys.contains(type.HEIGHT))
    }
}