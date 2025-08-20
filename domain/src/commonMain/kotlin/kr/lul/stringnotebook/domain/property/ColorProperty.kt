package kr.lul.stringnotebook.domain.property

import kr.lul.stringnotebook.domain.foundation.Property.Companion.id
import kr.lul.stringnotebook.domain.foundation.ScalarProperty
import kr.lul.stringnotebook.domain.type.ColorPropertyType
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * RGBA 색상.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
class ColorProperty(
    id: Uuid,
    name: String,
    override var value: Long
) : ScalarProperty<Long>(id, ColorPropertyType, name) {
    companion object {
        val HEX_FORMAT: HexFormat = HexFormat {
            number.removeLeadingZeros = true
        }

        /**
         * 각 RGBA 채널의 값이 0에서 255 사이인지 확인합니다.
         * @param channel 채널 값
         * @param name 채널 이름 (예: "red", "green", "blue", "alpha")
         * @return `channel` 값이 유효한 경우 그대로 반환합니다.
         * @throws IllegalArgumentException `channel` 값이 0에서 255 사이가 아니면 예외를 발생시킵니다.
         */
        @Throws(IllegalArgumentException::class)
        fun requireColorChannel(channel: Int, name: String): Int {
            require(channel in 0..255) {
                "$name channel must be between 0 and 255 : $name=$channel"
            }
            return channel
        }

        @Throws(IllegalArgumentException::class)
        fun requireColorChannel(channel: Float, name: String): Float {
            require(channel in 0.0F..1.0F) {
                "$name channel must be between 0.0 and 1.0 : $name=$channel"
            }
            return channel
        }
    }

    constructor(name: String, value: Long) : this(id(Random.nextLong(0xFFFFFFFFFFL)), name, value)

    constructor(id: Uuid, name: String, red: Int, green: Int, blue: Int, alpha: Int) : this(
        id = id,
        name = name,
        value = ((requireColorChannel(red, "red") and 0xFF).toLong() shl 24) or
                ((requireColorChannel(green, "green") and 0xFF).toLong() shl 16) or
                ((requireColorChannel(blue, "blue") and 0xFF).toLong() shl 8) or
                (requireColorChannel(alpha, "alpha") and 0xFF).toLong()
    )

    constructor(name: String, red: Int, green: Int, blue: Int, alpha: Int) : this(
        id = id(Random.nextLong(0xFFFFFFFFFFL)),
        name = name,
        value = ((requireColorChannel(red, "red") and 0xFF).toLong() shl 24) or
                ((requireColorChannel(green, "green") and 0xFF).toLong() shl 16) or
                ((requireColorChannel(blue, "blue") and 0xFF).toLong() shl 8) or
                (requireColorChannel(alpha, "alpha") and 0xFF).toLong()
    )

    constructor(id: Uuid, name: String, red: Float, green: Float, blue: Float, alpha: Float) : this(
        id = id,
        name = name,
        red = (requireColorChannel(red, "red") * 255).toInt(),
        green = (requireColorChannel(green, "green") * 255).toInt(),
        blue = (requireColorChannel(blue, "blue") * 255).toInt(),
        alpha = (requireColorChannel(alpha, "alpha") * 255).toInt()
    )

    constructor(name: String, red: Float, green: Float, blue: Float, alpha: Float) : this(
        name = name,
        red = (requireColorChannel(red, "red") * 255).toInt(),
        green = (requireColorChannel(green, "green") * 255).toInt(),
        blue = (requireColorChannel(blue, "blue") * 255).toInt(),
        alpha = (requireColorChannel(alpha, "alpha") * 255).toInt()
    )

    val red: Int
        get() = ((value and 0xFF000000L) shr 24).toInt()
    val green: Int
        get() = ((value and 0xFF0000L) shr 16).toInt()
    val blue: Int
        get() = ((value and 0x00FF00L) shr 8).toInt()
    val alpha: Int
        get() = ((value and 0x0000FFL)).toInt()

    val hex: String
        get() = "#${
            red.toHexString(HEX_FORMAT).padStart(2, '0')
        }${
            green.toHexString(HEX_FORMAT).padStart(2, '0')
        }${
            blue.toHexString(HEX_FORMAT).padStart(2, '0')
        }${
            alpha.toHexString(HEX_FORMAT).padStart(2, '0')
        }"

    override fun toString() = listOf(
        super.toString(),
        "red=$red",
        "green=$green",
        "blue=$blue",
        "alpha=$alpha"
    ).joinToString(", ", "ColorProperty(", ")")
}
