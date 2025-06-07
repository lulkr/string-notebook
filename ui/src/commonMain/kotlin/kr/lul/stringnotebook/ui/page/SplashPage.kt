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
import kr.lul.stringnotebook.state.atom.Res
import kr.lul.stringnotebook.state.atom.name
import kr.lul.stringnotebook.state.page.SplashPageHandler
import kr.lul.stringnotebook.state.page.SplashPageState
import kr.lul.stringnotebook.state.page.SplashPageState.Fail
import kr.lul.stringnotebook.state.page.SplashPageState.InProgress
import kr.lul.stringnotebook.state.page.SplashPageState.Init
import kr.lul.stringnotebook.state.page.SplashPageState.Success
import org.jetbrains.compose.resources.stringResource

@Composable
fun SplashPage(state: SplashPageState, handler: SplashPageHandler) {
    when (state) {
        is Init ->
            SplashInitPage(state, handler)

        is InProgress ->
            SplashInProgressPage(state, handler)

        is Success ->
            SplashSuccessPage(state, handler)

        is Fail ->
            SplashErrorPage(state, handler)
    }
}

@Composable
fun SplashInitPage(state: Init, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.name),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun SplashInProgressPage(state: InProgress, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.name),
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun SplashSuccessPage(state: Success, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.name),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(32.dp))
        Text("OK", color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Composable
fun SplashErrorPage(state: Fail, handler: SplashPageHandler) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.errorContainer),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.name),
            color = MaterialTheme.colorScheme.onErrorContainer,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(Modifier.height(32.dp))

        Text(
            text = state.cause.message ?: "Unknown Error",
            color = MaterialTheme.colorScheme.onErrorContainer,
        )
    }
}
