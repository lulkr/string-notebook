package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.page.SplashPageHandler
import kr.lul.stringnotebook.state.page.SplashPageState

@Composable
fun SplashPage(state: SplashPageState, handler: SplashPageHandler) {
    when (state) {
        is SplashPageState.Init ->
            SplashInitPage(state, handler)

        is SplashPageState.InProgress ->
            SplashInProgressPage(state, handler)

        is SplashPageState.Success ->
            SplashSuccessPage(state, handler)

        is SplashPageState.Fail ->
            SplashErrorPage(state, handler)
    }
}

@Composable
fun SplashInitPage(state: SplashPageState.Init, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(text = "String Notebook", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun SplashInProgressPage(state: SplashPageState.InProgress, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = "String Notebook",
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun SplashSuccessPage(state: SplashPageState.Success, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = "String Notebook",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun SplashErrorPage(state: SplashPageState.Fail, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.errorContainer),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = "String Notebook",
            color = MaterialTheme.colorScheme.error,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(32.dp))

        Text(
            text = state.cause.message ?: "Unknown Error",
            color = MaterialTheme.colorScheme.error,
        )
    }
}
