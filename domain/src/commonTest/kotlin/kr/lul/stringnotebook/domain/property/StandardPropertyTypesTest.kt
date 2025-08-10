package kr.lul.stringnotebook.domain.property

import kr.lul.logger.Logger
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class StandardPropertyTypesTest {
    private val logger = Logger("StandardPropertyTypesTest")

    @Test
    fun `id 중복이 있는지 검사한다`() {
        // GIVEN
        val entries = StandardPropertyTypes.entries
        logger.i("[GIVEN] entries=${entries.toList()}")

        // WHEN
        val ids = entries.map { it.type.id }.toSet()
        logger.i("[WHEN] ids=$ids")

        // THEN
        assertEquals(entries.size, ids.size)
    }

    @Test
    fun `이름 중복이 있는지 검사한다`() {
        // GIVEN
        val entries = StandardPropertyTypes.entries
        logger.i("[GIVEN] entries=${entries.toList()}")

        // WHEN
        val names = entries.map { it.type.name }.toSet()
        logger.i("[WHEN] names=$names")

        // THEN
        assertEquals(entries.size, names.size)
    }
}