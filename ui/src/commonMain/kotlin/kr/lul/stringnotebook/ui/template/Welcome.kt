package kr.lul.stringnotebook.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kr.lul.stringnotebook.state.template.WelcomeHandler
import kr.lul.stringnotebook.state.template.WelcomeState
import kr.lul.stringnotebook.ui.page.logger

@Composable
fun Welcome(state: WelcomeState, handler: WelcomeHandler) {
    logger.v("#Welcome args : state=$state, handler=$handler")

    Box(
        modifier = Modifier.sizeIn(minWidth = 600.dp, minHeight = 400.dp)
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .padding(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = state.message,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}