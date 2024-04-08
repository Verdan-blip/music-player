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
