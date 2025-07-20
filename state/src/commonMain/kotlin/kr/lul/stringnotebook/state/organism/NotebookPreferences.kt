package kr.lul.stringnotebook.state.organism

import androidx.compose.runtime.Stable

/**
 * 노트북 설정.
 */
@Stable
interface NotebookPreferences {
    object Default : NotebookPreferences
}
