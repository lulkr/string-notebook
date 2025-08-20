package kr.lul.stringnotebook.domain.anchor

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class PlainAnchorTest {
    private val logger = Logger("PlainAnchorTest")

    private lateinit var before: Instant

    @BeforeTest
    fun setUp() {
        before = Clock.System.now()
        logger.i("[SETUP] before=$before")
    }

    @Test
    fun `constructor - 기본값으로 생성`() {
        // WHEN
        val anchor = PlainAnchor()
        logger.i("[WHEN] anchor=$anchor")

        // THEN
        assertEquals(PlainAnchorType, anchor.type)
        assertNull(anchor.name)
        assertNull(anchor.memo)
        assertTrue(before < anchor.createdAt)
        assertEquals(anchor.createdAt, anchor.updatedAt)
    }
}