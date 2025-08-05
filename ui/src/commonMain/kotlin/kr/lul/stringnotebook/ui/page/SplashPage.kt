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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.page.SplashPageHandler
import kr.lul.stringnotebook.state.page.SplashPageState
import kr.lul.stringnotebook.state.page.SplashPageState.Fail
import kr.lul.stringnotebook.state.page.SplashPageState.InProgress
import kr.lul.stringnotebook.state.page.SplashPageState.Init
import kr.lul.stringnotebook.state.page.SplashPageState.Success
import kr.lul.stringnotebook.state.resources.Res
import kr.lul.stringnotebook.state.resources.name
import kr.lul.stringnotebook.state.resources.ui_error_unknown
import org.jetbrains.compose.resources.stringResource
import kotlin.uuid.ExperimentalUuidApi

/**
 * `SplashPage`
 *
 * - [Figma 디자인](https://www.figma.com/design/tNIeYiEjJyahF30EAaJrjy/String-Notebook-UI?node-id=1-9)
 */
@Composable
@ExperimentalUuidApi
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

/**
 * 첫 상태.
 *
 * 앱 초기화를 시작할 때까지만 표시한다.
 */
@Composable
fun SplashInitPage(state: Init, handler: SplashPageHandler) {
    Column(
        Modifier
            .testTag(state.testTag)
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

/**
 * 앱 초기화 진행 중일 때.
 */
@Composable
fun SplashInProgressPage(state: InProgress, handler: SplashPageHandler) {
    Column(
        Modifier
            .testTag(state.testTag)
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

/**
 * 앱 초기화를 끝낸 상태.
 *
 * 화면 이동할 때 까지만 표시한다.
 */
@Composable
fun SplashSuccessPage(state: Success, handler: SplashPageHandler) {
    Column(
        Modifier
            .testTag(state.testTag)
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

/**
 * 앱 초기화에 실패한 경우.
 */
@Composable
@ExperimentalUuidApi
fun SplashErrorPage(state: Fail, handler: SplashPageHandler) {
    Column(
        Modifier
            .testTag(state.testTag)
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
            text = state.cause.message
                ?: stringResource(Res.string.ui_error_unknown),
            color = MaterialTheme.colorScheme.onErrorContainer,
        )
    }
}
