package kr.lul.stringnotebook.viewmodel.template

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.domain.foundation.Event
import kr.lul.stringnotebook.domain.foundation.EventProcessor
import kr.lul.stringnotebook.state.organism.Context
import kr.lul.stringnotebook.state.organism.NotebookFocusedContext
import kr.lul.stringnotebook.state.organism.NotebookMenuContext
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.organism.ObjectEditContext
import kr.lul.stringnotebook.state.organism.ObjectFocusedContext
import kr.lul.stringnotebook.state.organism.ObjectPreviewContext
import kr.lul.stringnotebook.viewmodel.atom.BaseViewModelet
import kr.lul.stringnotebook.viewmodel.atom.ViewModeletOwner
import kr.lul.stringnotebook.viewmodel.organism.NotebookFocusedContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.NotebookMenuContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.ObjectEditContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.ObjectFocusedContextEventProcessor
import kr.lul.stringnotebook.viewmodel.organism.ObjectPreviewContextEventProcessor
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class NotebookViewModelet(
    tag: String,
    page: ViewModeletOwner,
    initState: NotebookState
) : BaseViewModelet(page, tag), EventProcessor {
    internal val _notebook = MutableStateFlow(initState)
    val notebook: StateFlow<NotebookState> = _notebook

    internal val _context = MutableStateFlow<Context>(NotebookFocusedContext())
    val context: StateFlow<Context> = _context

    private val notebookFocused = NotebookFocusedContextEventProcessor("${tag}.notebookFocused")
    private val notebookMenu = NotebookMenuContextEventProcessor("${tag}.notebookMenu")
    private val objectFocused = ObjectFocusedContextEventProcessor("${tag}.objectFocused")
    private val objectEdit = ObjectEditContextEventProcessor("${tag}.objectEdit")
    private val objectPreview = ObjectPreviewContextEventProcessor("${tag}.objectPreview")

    override fun invoke(event: Event) {
        logger.d("#invoke args : event=$event")

        val notebook = _notebook.value
        val context = _context.value
        logger.d("#invoke : notebook=$notebook, context=$context")

        when (context) {
            is NotebookFocusedContext -> notebookFocused(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is NotebookMenuContext -> notebookMenu(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is ObjectFocusedContext -> objectFocused(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is ObjectEditContext -> objectEdit(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            is ObjectPreviewContext -> objectPreview(notebook, context, event) { note, ctx ->
                launch {
                    _notebook.emit(note)
                    _context.emit(ctx)
                }
            }

            else -> {}
            // TODO rollback
            // throw IllegalStateException("Unsupported context for NotebookViewModelet: context::class=${context::class.qualifiedName}, context=$context")
        }

        logger.d("#invoke completed : this=$this")
    }

    override fun toString() = listOf(
        "notebook=${_notebook.value}",
        "context=${_context.value}"
    ).joinToString(", ", "$tag(", ")")
}