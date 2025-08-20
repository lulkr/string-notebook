package kr.lul.stringnotebook.domain.foundation

import kr.lul.semver.Version
import kr.lul.stringnotebook.domain.foundation.Configuration.generateId
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 코드 수준의 String Notebook의 설정 정보.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
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
     *
     * `BEEFCAFE-4096-0001-0001-############` 형식으로 지정된다.
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
     * 노트북 정보에 관한 ID 접두사.
     *
     * `BEEFCAFE-4096-0002-####-############` 형식으로 지정된다.
     */
    const val ID_PREFIX_NOTEBOOK = "$ID_PREFIX-0002"

    /**
     * 속성 타입의 ID 접두사.
     *
     * `BEEFCAFE-4096-0002-0001-############` 형식으로 지정된다.
     */
    const val ID_PREFIX_NOTEBOOK_PROPERTY_TYPE = "$ID_PREFIX_NOTEBOOK-0001"

    /**
     * 노트북 속성에 관한 ID 접두사.
     *
     * `BEEFCAFE-4096-0002-0002-################` 형식으로 지정된다.
     */
    const val ID_PREFIX_NOTEBOOK_PROPERTY = "$ID_PREFIX_NOTEBOOK-0002"

    /**
     * 앵커 타입의 ID 접두사.
     *
     * `BEEFCAFE-4096-0002-0003-############` 형식으로 지정된다.
     */
    const val ID_PREFIX_NOTEBOOK_ANCHOR_TYPE = "$ID_PREFIX_NOTEBOOK-0003"

    /**
     * 앵커의 ID 접두사.
     *
     * `BEEFCAFE-4096-0002-0004-############` 형식으로 지정된다.
     */
    const val ID_PREFIX_NOTEBOOK_ANCHOR = "$ID_PREFIX_NOTEBOOK-0004"

    /**
     * ID 생성에 사용할 수 있는 접두사 목록.
     *
     * @see generateId
     */
    private val ID_GENERATION_PREFIXES = setOf(
        ID_PREFIX_APP_BUILD,
        ID_PREFIX_APP_INSTALL,
        ID_PREFIX_APP_PROCESS,
        ID_PREFIX_NOTEBOOK_PROPERTY_TYPE,
        ID_PREFIX_NOTEBOOK_PROPERTY,
        ID_PREFIX_NOTEBOOK_ANCHOR_TYPE,
        ID_PREFIX_NOTEBOOK_ANCHOR
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
        "ID_PREFIX_NOTEBOOK_PROPERTY_TYPE='$ID_PREFIX_NOTEBOOK_PROPERTY_TYPE'",
        "ID_PREFIX_NOTEBOOK_PROPERTY='$ID_PREFIX_NOTEBOOK_PROPERTY'",
        "ID_PREFIX_NOTEBOOK_ANCHOR_TYPE='$ID_PREFIX_NOTEBOOK_ANCHOR_TYPE'",
        "ID_PREFIX_NOTEBOOK_ANCHOR='$ID_PREFIX_NOTEBOOK_ANCHOR'",
    ).joinToString(", ", "Configuration(", ")")
}