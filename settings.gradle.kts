import java.util.Properties

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

@Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        gradlePluginPortal()
        mavenCentral()
    }
}

val config = Properties().apply {
    load(file("local.properties").reader())
}
gradle.extra["config"] = config

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google {
            google {
                mavenContent {
                    includeGroupAndSubgroups("androidx")
                    includeGroupAndSubgroups("com.android")
                    includeGroupAndSubgroups("com.google")
                }
            }
        }
        mavenCentral()

        mavenLocal()
        maven {
            name = "LulKrPackages"
            url = uri("https://maven.pkg.github.com/lulkr/packages")

            credentials {
                username = config["github.actor"] as String?
                    ?: System.getenv("GITHUB_ACTOR")
                password = config["github.token"] as String?
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            name = "LulKrSnapshotPackages"
            url = uri("https://maven.pkg.github.com/lulkr/packages/snapshots")

            credentials {
                username = config["github.actor"] as String?
                    ?: System.getenv("GITHUB_ACTOR")
                password = config["github.token"] as String?
                    ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

rootProject.name = "StringNotebook"

include(
    ":app",
    ":data",
    ":domain",
    ":model",
    ":navigation",
    ":state",
    ":ui",
    ":viewmodel"
)
include(":shared")