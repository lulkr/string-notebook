package kr.lul.stringnotebook.domain.foundation

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_GENERATION_PREFIXES
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("NonAsciiCharacters")
class ConfigurationTest {
    private val logger = Logger("ConfigurationTest")

    @Test
    fun `id prefix 중복 테스트`() {
        // GIVEN
        val ids = mutableSetOf<String>()

        // WHEN
        for (prefix in ID_GENERATION_PREFIXES) {
            ids.add(prefix)
            logger.i("[WHEN] prefix=$prefix")
        }

        // THEN
        logger.i("[THEN] ids=$ids")
        assertEquals(ID_GENERATION_PREFIXES.size, ids.size)
    }
}