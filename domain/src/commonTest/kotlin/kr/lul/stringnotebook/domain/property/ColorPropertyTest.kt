package kr.lul.stringnotebook.domain.property

import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.type.ColorType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalStdlibApi
@ExperimentalUuidApi
@Suppress("NonAsciiCharacters")
class ColorPropertyTest {
    private val logger = Logger("ColorPropertyTest")

    @Test
    fun `constructor - 기본 생성자`() {
        // GIVEN
        val value = 0x01234567L
        logger.i("[GIVEN] value=$value${value.toHexString().uppercase()}")

        // WHEN
        val property = ColorProperty(name = "test", value = value)
        logger.i("[WHEN] property=$property(0x${property.value.toHexString().uppercase()})")

        // THEN
        assertEquals(0x01, property.red)
        assertEquals(0x23, property.green)
        assertEquals(0x45, property.blue)
        assertEquals(0x67, property.alpha)
        assertEquals("#01234567", property.hex)
        assertEquals(value, property.value)
        assertEquals("test", property.name)
        assertEquals(ColorType, property.type)
    }

    @Test
    fun `constructor - Int RGBA 값으로 생성`() {
        // GIVEN
        val red = 0x12
        val green = 0x34
        val blue = 0x56
        val alpha = 0x78
        logger.i("[GIVEN] red=$red, green=$green, blue=$blue, alpha=$alpha")

        // WHEN
        val property = ColorProperty(name = "test", red, green, blue, alpha)
        logger.i("[WHEN] property=$property(0x${property.value.toHexString().uppercase()})")

        // THEN
        assertEquals(red, property.red)
        assertEquals(green, property.green)
        assertEquals(blue, property.blue)
        assertEquals(alpha, property.alpha)
        assertEquals("#12345678", property.hex)
    }

    @Test
    fun `constructor - Float RGBA 값으로 생성`() {
        // GIVEN
        val red = 0.12F
        val green = 0.34F
        val blue = 0.56F
        val alpha = 0.78F
        logger.i("[GIVEN] red=$red, green=$green, blue=$blue, alpha=$alpha")

        // WHEN
        val property = ColorProperty(name = "test", red, green, blue, alpha)
        logger.i("[WHEN] property=$property(0x${property.value.toHexString().uppercase()})")

        // THEN
        assertEquals((red * 255).toInt(), property.red)
        assertEquals((green * 255).toInt(), property.green)
        assertEquals((blue * 255).toInt(), property.blue)
        assertEquals((alpha * 255).toInt(), property.alpha)
    }
}