package kr.lul.stringnotebook.domain.foundation

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_BUILD
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_INSTALL
import kr.lul.stringnotebook.domain.foundation.Configuration.ID_PREFIX_APP_PROCESS
import kr.lul.stringnotebook.domain.type.LengthType
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class TypeTest {
    private val logger = Logger("TypeTest")

    @Test
    fun `쓸 수 없는 ID를 걸러내는지 확인하기`() {
        for (text in listOf(
            "0998a95e-0808-4b57-b0f6-fcaa19c4604e",
            "${ID_PREFIX_APP_BUILD}-fcaa19c4604e",
            "${ID_PREFIX_APP_INSTALL}-fcaa19c4604e",
            "${ID_PREFIX_APP_PROCESS}-fcaa19c4604e"
        )) {
            val id = Uuid.parse(text)
            logger.i("[GIVEN] id=$id")

            // WHEN
            val ex1 = assertFails {
                object : ScalarType(
                    id,
                    "unit test",
                    "실패해야 하는 테스트"
                ) {}
            }
            val ex2 = assertFails {
                object : CompositeType(
                    id,
                    "unit test",
                    "실패해야 하는 테스트",
                    mapOf("ut" to LengthType)
                ) {}
            }
            logger.i("[WHEN] ex1=$ex1, ex2=$ex2")

            // THEN
            assertNotNull(ex1)
            assertNotNull(ex2)
            println()
        }
    }

    @Test
    fun `쓸 수 없는 이름을 걸러내는지 확인하기`() {
        for (name in listOf(
            "",
            " ",
            "\t",
            "\n",
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
            "A_",
            "Ab",
            "A1",
            "A_b",
            "A_1"
        )) {
            logger.i("[GIVEN] name=$name")

            // WHEN
            val ex1 = assertFailsWith<IllegalArgumentException> {
                object : ScalarType(
                    id = id(Random.nextLong(Long.MAX_VALUE)),
                    name = name,
                    description = "실패해야 하는 테스트"
                ) {}
            }
            val ex2 = assertFailsWith<IllegalArgumentException> {
                object : CompositeType(
                    id = id(Random.nextLong(Long.MAX_VALUE)),
                    name = name,
                    description = "실패해야 하는 테스트",
                    properties = mapOf("ut" to LengthType)
                ) {}
            }
            logger.i("[WHEN] ex1=$ex1, ex2=$ex2")

            // THEN
            assertNotNull(ex1)
            assertNotNull(ex2)
            println()
        }
    }

    @Test
    fun `쓸 수 있는 속성 이름 확인하기`() {
        for (name in listOf(
            "a",
            "a_b",
            "a1"
        )) {
            logger.i("[GIVEN] name=$name")

            // WHEN
            val type = object : CompositeType(
                id = id(Random.nextLong(1_000)),
                name = "test type",
                description = "성공해야 하는 테스트",
                properties = mapOf(name to LengthType)
            ) {}
            logger.i("[WHEN] type=$type")

            // THEN
            assertNotNull(type)
            assertEquals(name, type.properties.keys.first())
            println()
        }
    }

    @Test
    fun `쓸 수 없는 속성 이름 걸러내기`() {
        for (name in listOf(
            "",
            " ",
            "\t",
            "\n",
            "***",
            "a_b_c d",
            "123"
        )) {
            logger.i("[GIVEN] name=$name")

            // WHEN
            val ex = assertFailsWith<IllegalArgumentException> {
                object : CompositeType(
                    id = id(Random.nextLong(Long.MAX_VALUE)),
                    name = "test type",
                    description = "실패해야 하는 테스트",
                    properties = mapOf(name to LengthType)
                ) {}
            }
            logger.i("[WHEN] ex=$ex")

            // THEN
            assertNotNull(ex)
            println()
        }
    }
}