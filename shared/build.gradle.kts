plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { target ->
        target.binaries.framework {
            baseName = "SharedKit"

            dependencies {
                export(projects.navigation)
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.navigation)

            implementation(projects.mcp)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.util.logger)
        }
    }
}
