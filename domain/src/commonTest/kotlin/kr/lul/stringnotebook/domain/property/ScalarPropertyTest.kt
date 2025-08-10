package kr.lul.stringnotebook.domain.property

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Property
import kr.lul.stringnotebook.domain.foundation.ScalarProperty
import kr.lul.stringnotebook.domain.type.LengthType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNotNull
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class ScalarPropertyTest {
    private val logger = Logger("ScalarPropertyTest")

    @Test
    fun `쓸 수 있는 이름 검사하기`() {
        for (name in listOf(
            "a",
            "a1",
            "a_1",
            "ab",
            "a_b",
            "a_b1",
            "aB",
            "aB1",
            "aB_1"
        )) {
            // GIVEN
            logger.i("[GIVEN] name=$name")

            // WHEN
            val property = object : ScalarProperty<Float>(
                id = Property.id(0L),
                type = LengthType,
                name = name
            ) {
                override var value: Float = 0F
            }
            logger.i("[WHEN] property=$property")

            // THEN
            assertEquals(name, property.name)
            println()
        }
    }

    @Test
    fun `쓸 수 없는 이름 검사하기`() {
        for (name in listOf(
            "",
            "a b",
            "a-b",
            "a.b",
            "a@b",
            "a#b",
            "a\$b",
            "a%b",
            "a^b",
            "a&b",
            "a*b",
            "a(b",
            "a)b",
            "a{b",
            "a}b",
            "a[b",
            "a]b"
        )) {
            // GIVEN
            logger.i("[GIVEN] name=$name")

            // WHEN
            val exception = assertFails {
                object : ScalarProperty<Float>(
                    id = Property.id(0L),
                    type = LengthType,
                    name = name
                ) {
                    override var value: Float = 0F
                }
            }
            logger.i("[WHEN] exception=$exception")

            // THEN
            assertNotNull(exception)
            println()
        }
    }
}