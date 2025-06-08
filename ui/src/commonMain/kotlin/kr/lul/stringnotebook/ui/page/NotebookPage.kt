package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.domain.event.AddAnchorEvent
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.ui.atom.LocalEventProcessor
import kr.lul.stringnotebook.ui.template.VisualNotebookEditor
import kotlin.random.Random
import kotlin.uuid.ExperimentalUuidApi

@Composable
@OptIn(ExperimentalUuidApi::class)
fun NotebookPage(state: NotebookPageState) {
    logger.v("#NotebookPage args : state=$state")

    when (state) {
        is NotebookPageState.Initial ->
            NotebookPageInitial(state)

        is NotebookPageState.Loading ->
            NotebookPageLoading(state)

        is NotebookPageState.Editing ->
            NotebookPageEditing(state)
    }
}

@Composable
fun NotebookPageInitial(state: NotebookPageState.Initial) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("$state")
    }
}

@Composable
fun NotebookPageLoading(state: NotebookPageState.Loading) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text("$state")
        Text("Loading...")
    }
}

@Composable
@ExperimentalUuidApi
fun NotebookPageEditing(
    state: NotebookPageState.Editing
) {
    val eventProcessor = LocalEventProcessor.current

    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        VisualNotebookEditor(
            state = state.notebook,
            modifier = Modifier.fillMaxWidth().weight(1F).background(MaterialTheme.colorScheme.background)
        )

        Row(modifier = Modifier.fillMaxWidth().padding(4.dp), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { eventProcessor(AddAnchorEvent(x = Random.nextInt(400), y = Random.nextInt(400))) }) {
                Text("+")
            }
        }
    }
}