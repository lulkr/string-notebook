package kr.lul.stringnotebook.domain.type

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.LengthType.ID_SUFFIX
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi

@Suppress("NonAsciiCharacters")
@ExperimentalStdlibApi
@ExperimentalUuidApi
class LengthTypeTest {
    private val logger = Logger("LengthTypeTest")

    @Test
    fun `StandardPropertyTypes 등록 확인`() {
        // GIVEN
        val type = LengthType
        logger.i("[GIVEN] type=$type")

        // THEN
        assertEquals(type, StandardTypes[ID_SUFFIX].type)
        assertEquals(type, StandardTypes[type].type)
        assertEquals(type, StandardTypes[type.id].type)
        assertEquals(type, StandardTypes[type.name].type)
    }
}