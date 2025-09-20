package kr.lul.stringnotebook.data.entity

import kr.lul.stringnotebook.data.entity.NotebookEntity.Companion.DEFAULT_NAME
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.notebook.Border
import kr.lul.stringnotebook.domain.notebook.Notebook
import kr.lul.stringnotebook.domain.property.ColorProperty
import kr.lul.stringnotebook.domain.property.PositionProperty
import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalTime
@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Notebook(
    id: Uuid = Uuid.random(),
    name: String = DEFAULT_NAME,
    memo: String? = null,
    anchorContainerBorder: Border? = null,
    anchorContainerBackground: ColorProperty? = null,
    anchorContainerPadding: Float? = null,
    anchorRadius: Float? = null,
    anchorColor: ColorProperty? = null,
    createdAt: Instant = Clock.System.now()
): Notebook = NotebookEntity(
    id,
    name,
    memo,
    anchorContainerBorder,
    anchorContainerBackground,
    anchorContainerPadding,
    anchorRadius,
    anchorColor,
    createdAt
)

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun Anchor(
    id: Uuid = Uuid.random(),
    type: AnchorType = PlainAnchorType,
    name: String? = null,
    memo: String? = null,
    position: PositionProperty = PositionProperty(x = 0F, y = 0F),
    createdAt: Instant = Clock.System.now()
) = AnchorEntity(id, type, name, memo, position, createdAt)

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
fun Anchor(
    id: Uuid = Uuid.random(),
    type: AnchorType = PlainAnchorType,
    name: String? = null,
    memo: String? = null,
    x: Float = 0F,
    y: Float = 0F,
    createdAt: Instant = Clock.System.now()
): Anchor = AnchorEntity(id, type, name, memo, PositionProperty(x = x, y = y), createdAt)