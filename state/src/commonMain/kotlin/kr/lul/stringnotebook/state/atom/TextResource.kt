package kr.lul.stringnotebook.state.atom

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

/**
 * 텍스트 리소스와 인자를 포함하는 데이터 클래스.
 *
 * @property resource 텍스트 리소스.
 * @property args 텍스트 리소스에 전달할 인자 목록.
 *
 * @see StringResource
 */
@Immutable
data class TextResource(
    val resource: StringResource,
    val args: List<Any> = emptyList()
) {
    constructor(resource: StringResource, vararg args: Any) : this(resource, args.toList())
}
