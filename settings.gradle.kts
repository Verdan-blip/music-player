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
include(":data")
include(":data:auth")
include(":core:common")
include(":features:player")
include(":core:theme")
include(":features:player:api")
include(":features:player:impl")
include(":data:music")
include(":features:feed")
include(":features:feed:api")
include(":features:feed:impl")
include(":player")
include(":player:api")
include(":player:impl")
include(":features:search")
include(":features:search:api")
include(":features:search:impl")
include(":data:music:api")
include(":data:music:impl")
include(":features:signup")
include(":data:auth:api")
include(":data:auth:impl")
include(":features:signin")
include(":features:profile")
include(":features:upload")
