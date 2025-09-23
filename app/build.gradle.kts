import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.hot.reload)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.model)
            implementation(projects.navigation)

            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
            implementation(libs.util.logger)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)
            implementation(libs.koin.android)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
    }
}

android {
    namespace = "${parent!!.group}.app"
    compileSdk = libs.versions.android.compile.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        applicationId = "${parent!!.group}.app"
        minSdk = libs.versions.android.min.get().toInt()
        targetSdk = libs.versions.android.target.get().toInt()
        versionCode = 1
        versionName = "${parent!!.version}"
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"

            isMinifyEnabled = false
            isShrinkResources = false
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

compose.desktop {
    application {
        mainClass = "${parent!!.group}.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg)

            packageName = "StringNotebook"
            packageVersion = "${parent!!.version}"

            macOS {
                iconFile.set(rootProject.file("doc/file/icon.svg"))
            }
        }

        buildTypes.release.proguard {
            configurationFiles.from(project.file("proguard-rules.pro"))
        }
    }
}
