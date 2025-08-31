package kr.lul.stringnotebook.data.entity

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kr.lul.stringnotebook.domain.foundation.Anchor
import kr.lul.stringnotebook.domain.foundation.AnchorType
import kr.lul.stringnotebook.domain.foundation.Notebook
import kr.lul.stringnotebook.domain.property.PositionProperty
import kr.lul.stringnotebook.domain.type.PlainAnchorType
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
fun Notebook(
    id: Uuid = Uuid.random(),
    name: String = NotebookEntity.DEFAULT_NAME,
    description: String? = null
): Notebook = NotebookEntity(id, name, description)

@ExperimentalStdlibApi
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