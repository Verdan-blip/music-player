pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

rootProject.name = "music-player"
include(":app")
include(":core")
include(":features")
include(":features:oauth")
include(":data")
include(":data:auth")
include(":core:common")
include(":navigation")
include(":features:player")
include(":core:theme")
include(":features:player:api")
include(":features:player:impl")
