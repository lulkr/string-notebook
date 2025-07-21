package kr.lul.stringnotebook.viewmodel.organism

import androidx.compose.ui.geometry.Offset
import kr.lul.logger.Logger
import kr.lul.stringnotebook.domain.event.EndMoveObjectEvent
import kr.lul.stringnotebook.domain.event.MovePreviewEvent
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.state.molecule.Area
import kr.lul.stringnotebook.state.organism.AnchorState
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NodeState
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectPreviewContext
import kr.lul.stringnotebook.state.organism.ObjectState
import kr.lul.stringnotebook.state.organism.PreviewAnchorState
import kr.lul.stringnotebook.state.organism.PreviewNodeState
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class ObjectPreviewContextEventProcessor(
    tag: String
) {
    private val logger = Logger(tag)

    operator fun invoke(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: Event,
        callback: (NotebookState, Context) -> Unit
    ) {
        logger.d("#invoke args : notebook=$notebook, context=$context, event=$event, callback=$callback")
        when (event) {
            is EndMoveObjectEvent -> handle(notebook, context, event, callback)
            is MovePreviewEvent -> handle(notebook, context, event, callback)
            else -> {}
            //throw IllegalArgumentException("unsupported event: ${event::class.qualifiedName}, event=$event")
        }
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: EndMoveObjectEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "target object not found: event.target=${event.target}" }
        require(target == context.target) { "target does not match : event.target=${event.target}, context.target=${context.target}" }

        when (target) {
            is AnchorState -> {
                val preview = requireNotNull(target.preview) { "anchor preview not found: target=$target" }

                val dropTargets = dropTargets(Offset(preview.x, preview.y), notebook.objects)
                if (dropTargets.isEmpty()) {

                    target.x = preview.x
                    target.y = preview.y
                    target.preview = null

                    notebook.objects.filterNot { it.id == preview.id }
                } else {
                    // TODO 링크하기가 있는 앵커 메뉴 표시.
                    logger.w("#handle drop target found : target=$target, dropTargets=$dropTargets")
                }
            }

            is NodeState -> {
                val preview = requireNotNull(target.preview) { "node preview not found: target=$target" }

                target.x = preview.x
                target.y = preview.y
                target.preview = null

                callback(
                    notebook.copy(objects = notebook.objects.filterNot {
                        it.id == preview.id
                    }),
                    context.focus(target)
                )
            }

            else ->
                throw IllegalArgumentException("unsupported target type : target::class=${target::class.qualifiedName}")
        }
    }

    private fun dropTargets(offset: Offset, objects: List<ObjectState>): List<ObjectState> {
        val padding = 32.0F // TODO 노트북, 앵커 혹은 노드 속성으로 변경.
        return objects
            .filterNot { it is PreviewAnchorState || it is PreviewNodeState }
            .map {
                when (it) {
                    is AnchorState -> it to Area(
                        it.x - padding,
                        it.y - padding,
                        it.x + padding,
                        it.y + padding
                    )

                    is NodeState -> it to Area(
                        it.x - padding,
                        it.y - padding,
                        it.x + 150F + padding, // TODO 노드 크기 속성으로 변경.
                        it.y + 40F + padding // TODO 노드 크기 속성으로 변경.
                    )

                    else ->
                        throw IllegalArgumentException("unsupported target type : target::class=${it::class.qualifiedName}")
                }
            }.filter { it.second.contains(offset.x, offset.y) }
            .map { it.first }
    }

    fun handle(
        notebook: NotebookState,
        context: ObjectPreviewContext,
        event: MovePreviewEvent,
        callback: (NotebookState, Context) -> Unit
    ) {
        val target = notebook.objects.firstOrNull { event.target == it.id }
        requireNotNull(target) { "Target object not found: event.target=${event.target}" }

        val preview = when (target) {
            is AnchorState ->
                requireNotNull(target.preview) { "anchor preview not found : target=$target" }

            is NodeState ->
                requireNotNull(target.preview) { "node preview not found : target=$target" }

            else ->
                throw IllegalArgumentException("unsupported target type : target::class=${target::class.qualifiedName}")

        }
        preview.x = event.x
        preview.y = event.y

        callback(notebook, context)
    }
}