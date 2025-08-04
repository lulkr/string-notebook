package kr.lul.stringnotebook.ui.atom

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.atom.TextResource
import org.jetbrains.compose.resources.stringResource

val TextResource.string: String
    @Composable
    get() {
        return stringResource(resource, *args.toTypedArray())
    }