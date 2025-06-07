import dev.iurysouza.modulegraph.Orientation

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.multiplatform.android.library) apply false
    alias(libs.plugins.modulegraph)
}

group = "kr.lul.stringnotebook"
version = "1.0.0"

moduleGraphConfig {
    readmePath.set("./README.md")
    heading = "### Module Graph"

    orientation = Orientation.TOP_TO_BOTTOM
    setStyleByModuleType = true
    nestingEnabled = true
    showFullPath = true
    excludedConfigurationsRegex = ".*Only"
}