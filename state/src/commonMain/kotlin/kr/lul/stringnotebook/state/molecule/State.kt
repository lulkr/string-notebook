package kr.lul.stringnotebook.state.molecule

/**
 *
 * @property key 고유 키.
 * @property testTag [androidx.compose.ui.platform.testTag]에 사용할 태그.
 */
interface State {
    val key: Any

    val testTag: String

    val summary: String
}