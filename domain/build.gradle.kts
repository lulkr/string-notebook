import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.multiplatform.android.library)
}

kotlin {
    androidLibrary {
        namespace = "${parent!!.group}.domain"
        compileSdk = libs.versions.android.compile.get().toInt()
        minSdk = libs.versions.android.min.get().toInt()

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
            api(libs.kotlinx.datetime)
            api(libs.util.semver)

            implementation(libs.util.logger)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
        }

        iosMain.dependencies {
        }

        jvmMain.dependencies {
        }
    }
}