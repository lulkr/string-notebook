package kr.lul.stringnotebook.viewmodel.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.notebook.Notebook
import kr.lul.stringnotebook.state.atom.BackgroundState
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.molecule.PositionState
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.NotebookState
import kotlin.uuid.ExperimentalUuidApi

/**
 * [Notebook] 인스턴스를 UI 상태 홀더로 변환한다.
 */
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Notebook.toState() = NotebookState(
    id = id,
    name = name,
    memo = memo,
    anchors = anchors.map { anchor ->
        AnchorState(
            id = anchor.id,
            type = anchor.type,
            name = anchor.name,
            memo = anchor.memo,
            position = PositionState(anchor.position.x.value, anchor.position.y.value),
            createdAt = anchor.createdAt,
            updatedAt = anchor.updatedAt
        )
    },
    menu = null,
    anchorPropertiesDefault = AnchorProperties.Default.copy(
        containerBorder = anchorContainerBorder?.let { border ->
            BorderState(
                width = border.width.value.dp,
                color = border.color.run { Color(red, green, blue, alpha) },
                shape = CircleShape
            )
        } ?: AnchorProperties.Default.containerBorder,
        containerBackground = anchorContainerBackground?.let { background ->
            BackgroundState(Color(background.red, background.green, background.blue, background.alpha))
        } ?: AnchorProperties.Default.containerBackground,
        containerPadding = anchorContainerPadding?.let { padding -> PaddingValues(padding.dp) }
            ?: AnchorProperties.Default.containerPadding,
    ),
    createdAt = createdAt,
    updatedAt = updatedAt
)