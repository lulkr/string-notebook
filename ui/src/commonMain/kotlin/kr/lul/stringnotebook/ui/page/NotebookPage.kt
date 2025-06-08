package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.lul.stringnotebook.state.page.NotebookPageState
import kr.lul.stringnotebook.ui.organism.Notebook

@Composable
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
fun NotebookPageEditing(state: NotebookPageState.Editing) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Notebook(state.notebook, Modifier.fillMaxWidth().weight(1F))

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { }) {
                Text("+")
            }
        }
    }
}