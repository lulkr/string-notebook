package kr.lul.stringnotebook.viewmodel.organism

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.domain.notebook.ObservableNotebook
import kr.lul.stringnotebook.model.NotebookEventProcessor
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.atom.BorderState
import kr.lul.stringnotebook.state.atom.TextResource
import kr.lul.stringnotebook.state.atom.summary
import kr.lul.stringnotebook.state.molecule.PositionState
import kr.lul.stringnotebook.state.molecule.TextState
import kr.lul.stringnotebook.state.organism.AnchorProperties
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.MenuItemState
import kr.lul.stringnotebook.state.organism.MenuState
import kr.lul.stringnotebook.state.organism.NotebookHandler
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.molecule_context_menu_add_anchor
import kr.lul.stringnotebook.state.template.LayoutHandler
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModelet
import kr.lul.stringnotebook.viewmodel.foundation.ViewModeletOwner
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalStdlibApi
@ExperimentalUuidApi
class NotebookViewModelet(
    parent: ViewModeletOwner,
    tag: String,
    private val layoutHandler: LayoutHandler,
    private val model: NotebookModel,
    val id: Uuid
) : BaseViewModelet(parent, tag), NotebookHandler {
    private lateinit var notebook: ObservableNotebook
    private lateinit var eventProcessor: EventProcessor

    private val _state = MutableStateFlow<NotebookState?>(null)
    val state: StateFlow<NotebookState?> = _state

    override fun onChangeSize(size: Size) {
        logger.d("#onChangeSize args : size=${size.summary}")

        checkNotNull(state.value).size = size
    }

    override fun onClick(offset: Offset) {
        logger.d("#onClick args : offset=${offset.summary}")

        // TODO FSM 상태에 따른 동작 정의.

        val state = _state.value
        launch {
            if (state?.menu != null) {
                state.menu = null
            } else {
                layoutHandler.onChangeLayout()
            }
        }
    }

    override fun onDoubleClick(offset: Offset) = onLongClick(offset)

    override fun onLongClick(offset: Offset) {
        logger.d("#onLongClick args : offset=${offset.summary}")

        val state = _state.value
        if (state == null)
            throw IllegalStateException("Notebook state is not initialized yet.")

        launch {
            state.menu = MenuState(
                position = offset,
                items = listOf(
                    MenuItemState(
                        label = TextState(TextResource(Res.string.molecule_context_menu_add_anchor)),
                        onClick = {
                            logger.d("#menu.items[0].onClick add anchor : offset=$offset")
                            checkNotNull(state) { "Notebook state is not initialized yet." }

                            eventProcessor(AddAnchorEvent(x = offset.x, y = offset.y))
                            state.menu = null
                        }
                    )
                ),
                key = state.key,
                testTag = state.testTag
            )
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)

        launch {
            val notebook = model.read(id) ?: throw IllegalArgumentException("Notebook not found : id=$id")
            // TODO 노트북에서 UI 속성 읽기.
            val state = NotebookState(
                id = notebook.id,
                name = notebook.name,
                memo = notebook.memo,
                anchors = notebook.anchors.map { anchor ->
                    AnchorState(
                        id = anchor.id,
                        type = anchor.type,
                        name = anchor.name,
                        memo = anchor.memo ?: "",
                        position = PositionState(anchor.position.x.value, anchor.position.y.value),
                        createdAt = anchor.createdAt,
                        updatedAt = anchor.updatedAt
                    )
                },
                menu = null,
                anchorPropertiesDefault = AnchorProperties.Default.copy(
                    containerBorder = notebook.anchorContainerBorder?.let { border ->
                        BorderState(
                            width = border.width.value.dp,
                            color = border.color.run { Color(red, green, blue, alpha) },
                            shape = CircleShape
                        )
                    } ?: AnchorProperties.Default.containerBorder
                ),
                createdAt = notebook.createdAt,
                updatedAt = notebook.updatedAt
            )

            this@NotebookViewModelet.notebook = object : ObservableNotebook(notebook) {
                override fun afterChange() {
                    logger.d("#afterChange called.")
                    checkNotNull(state)

                    state.name = name
                    state.memo = memo
                    state.updatedAt = updatedAt

                    val currentAnchors = state.anchors.associateBy { it.id }
                    state.anchors = anchors.map {
                        if (currentAnchors.containsKey(it.id)) {
                            currentAnchors[it.id]!!
                        } else {
                            AnchorState(
                                id = it.id,
                                type = it.type,
                                name = it.name,
                                memo = it.memo,
                                position = PositionState(it.position.x.value, it.position.y.value),
                                createdAt = it.createdAt,
                                updatedAt = it.updatedAt
                            )
                        }
                    }

                    logger.v("#afterChange state changed : state=$state")
                }
            }
            eventProcessor = NotebookEventProcessor(this@NotebookViewModelet.notebook)

            _state.emit(state)
        }
    }

    override fun toString() = listOf(
        "id=$id",
        "state=$state"
    ).joinToString(", ", "NotebookViewModelet(", ")")
}