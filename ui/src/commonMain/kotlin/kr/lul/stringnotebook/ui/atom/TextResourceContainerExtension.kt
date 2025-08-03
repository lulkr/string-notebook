package kr.lul.stringnotebook.ui.atom

import androidx.compose.runtime.Composable
import kr.lul.stringnotebook.state.molecule.TextResourceContainer
import org.jetbrains.compose.resources.stringResource

val TextResourceContainer.string: String
    @Composable
    get() {
        val txt = stringResource(resource, *args.toTypedArray())
        return txt
    }