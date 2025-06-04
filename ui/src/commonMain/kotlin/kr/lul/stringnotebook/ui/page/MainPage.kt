package kr.lul.stringnotebook.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import kr.lul.stringnotebook.state.page.MainPageHandler
import kr.lul.stringnotebook.state.page.MainPageState

@Composable
fun MainPage(
    state: MainPageState,
    handler: MainPageHandler
) {
    logger.v("#MainPage args : state=$state, handler=$handler")

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Text(text = "Main Page", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineLarge)
    }
}