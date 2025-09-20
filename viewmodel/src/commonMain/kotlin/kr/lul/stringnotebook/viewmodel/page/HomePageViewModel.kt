package kr.lul.stringnotebook.viewmodel.page

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.page.HomePageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * 홈 화면의 ViewModel.
 *
 * @param initState 초기 상태.
 */
@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalUuidApi
class HomePageViewModel(
    private val model: NotebookModel,
    initState: HomePageState = HomePageState()
) : BaseViewModel("HomePageViewModel") {

    val state: StateFlow<HomePageState> = MutableStateFlow(initState)

    fun newNotebook(callback: (Uuid) -> Unit) {
        logger.d("#newNotebook args : callback=$callback")

        launch {
            val notebook = model.create()
            logger.d("#newNotebook : notebook=$notebook")

            callback(notebook.id)
        }
    }

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}
