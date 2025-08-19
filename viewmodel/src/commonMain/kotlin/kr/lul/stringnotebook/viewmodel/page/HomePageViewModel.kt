package kr.lul.stringnotebook.viewmodel.page

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.model.NotebookModel
import kr.lul.stringnotebook.state.organism.NotebookState
import kr.lul.stringnotebook.state.page.HomePageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kr.lul.stringnotebook.viewmodel.organism.state
import kotlin.uuid.ExperimentalUuidApi

/**
 * 홈 화면의 ViewModel.
 *
 * @param initState 초기 상태.
 */
@ExperimentalUuidApi
class HomePageViewModel(
    private val model: NotebookModel,
    initState: HomePageState = HomePageState()
) : BaseViewModel("HomePageViewModel") {

    val state: StateFlow<HomePageState> = MutableStateFlow(initState)

    fun newNotebook(callback: (NotebookState) -> Unit) {
        logger.d("#newNotebook args : callback=$callback")

        launch {
            val notebook = model.create().state
            logger.d("#newNotebook : notebook=$notebook")

            delay(1000L)
            callback(notebook)
        }
    }

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}
