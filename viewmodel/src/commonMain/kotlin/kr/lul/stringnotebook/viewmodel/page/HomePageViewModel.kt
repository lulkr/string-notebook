package kr.lul.stringnotebook.viewmodel.page

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.state.page.HomePageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class HomePageViewModel(
    initState: HomePageState = HomePageState()
) : BaseViewModel("HomePageViewModel") {

    val state: StateFlow<HomePageState> = MutableStateFlow(initState)

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}
