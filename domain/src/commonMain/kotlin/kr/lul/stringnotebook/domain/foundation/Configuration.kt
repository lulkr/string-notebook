package kr.lul.stringnotebook.domain.foundation

import kr.lul.semver.Version
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 코드 수준의 String Notebook의 설정 정보.
 */
@OptIn(ExperimentalUuidApi::class, ExperimentalStdlibApi::class)
object Configuration {
    const val NAME = "String Notebook"
    const val VERSION_VALUE = "0.0.1"

    val VERSION = Version(VERSION_VALUE)

    /**
     * String Notebook이 사용하는 모든 UUID 형식의 ID 접두사.
     */
    const val ID_PREFIX = "BEEFCAFE-4096"

    /**
     * Spring Notebook 앱 자체 정보에 관한 ID 접두사.
     */
    const val ID_PREFIX_APP = "$ID_PREFIX-0001"

    /**
     * String Notebook 앱 빌드 정보에 관한 ID 접두사.
     */
    const val ID_PREFIX_APP_BUILD = "$ID_PREFIX_APP-0001"

    /**
     * String Notebook 앱 설치 정보에 관한 ID 접두사.
     */
    const val ID_PREFIX_APP_INSTALL = "$ID_PREFIX_APP-0002"

    /**
     * String Notebook 앱 프로세스 정보에 관한 ID 접두사.
     *
     * 앱 실행 혹은 재실행 할 때 임의의 값으로 지정된다.
     * `BEEFCAFE-4096-0001-0003-############` 형식으로 지정된다.
     */
    const val ID_PREFIX_APP_PROCESS = "$ID_PREFIX_APP-0003"

    /**
     * 노트북 컨텐츠 종류의 ID 접두사.
     */
    const val ID_PREFIX_TYPE = "$ID_PREFIX-0002"

    /**
     * 노트북 컨텐츠가 가질 수 있는 속성 종류의 ID 접두사.
     *
     * @see ID_PREFIX_PROPERTY
     */
    const val ID_PREFIX_TYPE_PROPERTY = "$ID_PREFIX_TYPE-0001"

    /**
     * 노트북에 컨텐츠가 가질 수 있는 속성의 ID 접두사.
     *
     * @see ID_PREFIX_TYPE_PROPERTY
     */
    const val ID_PREFIX_PROPERTY = "$ID_PREFIX-0003-0001"

    /**
     * ID 생성에 사용할 수 있는 접두사 목록.
     *
     * @see generateId
     */
    private val ID_GENERATION_PREFIXES = setOf(
        ID_PREFIX_APP_BUILD,
        ID_PREFIX_APP_INSTALL,
        ID_PREFIX_APP_PROCESS,
        ID_PREFIX_TYPE_PROPERTY,
        ID_PREFIX_PROPERTY
    )

    /**
     * @see generateId
     */
    private val ID_GENERATION_HEX_FORMAT: HexFormat = HexFormat {
        upperCase = true
        number.minLength = 12
        number.removeLeadingZeros = true
    }

    /**
     * ID 접두사를 사용한 [Uuid] 생성 함수.
     */
    @ExperimentalStdlibApi
    fun String.generateId(suffix: Int): Uuid {
        require(ID_GENERATION_PREFIXES.any { startsWith(it) }) { "Invalid prefix : $this" }

        return Uuid.parse("$this-${suffix.toHexString(ID_GENERATION_HEX_FORMAT)}")
    }

    /**
     * ID 접두사를 사용한 [Uuid] 생성 함수.
     */
    @ExperimentalStdlibApi
    fun String.generateId(suffix: Long): Uuid {
        require(ID_GENERATION_PREFIXES.any { startsWith(it) }) { "Invalid prefix : $this" }

        return Uuid.parse("$this-${suffix.toHexString(ID_GENERATION_HEX_FORMAT)}")
    }

    override fun toString() = listOf(
        "NAME='$NAME'",
        "VERSION=$VERSION",
        "ID_PREFIX_APP_BUILD='$ID_PREFIX_APP_BUILD'",
        "ID_PREFIX_APP_INSTALL='$ID_PREFIX_APP_INSTALL'",
        "ID_PREFIX_APP_PROCESS='$ID_PREFIX_APP_PROCESS'",
        "ID_PREFIX_TYPE_PROPERTY='$ID_PREFIX_TYPE_PROPERTY'",
        "ID_PREFIX_PROPERTY='$ID_PREFIX_PROPERTY'"
    ).joinToString(", ", "Configuration(", ")")
}