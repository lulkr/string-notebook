package kr.lul.stringnotebook.state.molecule

import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.DrawableResource
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 아이콘 상태 홀더.
 */
@ExperimentalUuidApi
data class IconState(
    val icon: DrawableResource,
    val description: String? = null,
    val tint: Color = Color.Unspecified,
    override val key: Any = Uuid.random(),
    override val testTag: String = key.toString()
) : State
