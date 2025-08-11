package kr.lul.stringnotebook.domain.type

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.PositionType.ID_SUFFIX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class PositionTypeTest {
    private val logger = Logger("PositionTypeTest")

    @Test
    fun `StandardPropertyTypes 등록 확인`() {
        // GIVEN
        val type = PositionType
        logger.i("[GIVEN] type=$type")

        // THEN
        assertEquals(type, StandardTypes[ID_SUFFIX].type)
        assertEquals(type, StandardTypes[type].type)
        assertEquals(type, StandardTypes[type.id].type)
        assertEquals(type, StandardTypes[type.name].type)
        assertTrue(type.properties.keys.contains(type.X))
        assertTrue(type.properties.keys.contains(type.Y))
    }
}