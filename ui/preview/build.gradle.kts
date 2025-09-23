import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.multiplatform.android.library)
}

kotlin {
    androidLibrary {
        namespace = "${rootProject.group}.preview.ui"
        compileSdk = libs.versions.android.compile.get().toInt()
        minSdk = libs.versions.android.min.get().toInt()

        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(JvmTarget.JVM_17)
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        commonMain.dependencies {
            api(projects.state.preview)
            api(projects.ui)

            implementation(libs.util.logger)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.androidx.customview.poolingcontainer)
            implementation(libs.androidx.emoji2)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "${rootProject.group}.preview.ui"
    generateResClass = auto
}