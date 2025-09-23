import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.multiplatform.android.library)
}

kotlin {
    androidLibrary {
        namespace = "${parent!!.group}.navigation"
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
            api(projects.ui)
            api(libs.koin.viewmodel.navigation)

            implementation(projects.viewmodel)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.util.logger)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "${rootProject.group}.navigation"
    generateResClass = auto
}