package kr.lul.stringnotebook.viewmodel.page

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kr.lul.stringnotebook.state.page.MainPageState
import kr.lul.stringnotebook.viewmodel.foundation.BaseViewModel
import kotlin.uuid.ExperimentalUuidApi

@ExperimentalUuidApi
class MainPageViewModel(
    initState: MainPageState = MainPageState()
) : BaseViewModel("MainPageViewModel") {

    val state: StateFlow<MainPageState> = MutableStateFlow(MainPageState())

    override fun toString() = listOf(
        "state=${state.value}"
    ).joinToString(", ", "$tag(", ")")
}
