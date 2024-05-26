plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "ru.kpfu.itis.bagaviev"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.kpfu.itis.bagaviev"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        renderscriptTargetApi = 34
        renderscriptSupportModeEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":data:music:api"))
    implementation(project(":data:music:impl"))

    implementation(project(":core:common"))

    implementation(project(":player:api"))
    implementation(project(":player:impl"))

    implementation(project(":features:player:api"))
    implementation(project(":features:player:impl"))

    implementation(project(":features:feed:api"))
    implementation(project(":features:feed:impl"))

    implementation(project(":features:search:api"))
    implementation(project(":features:search:impl"))

    implementation(project(":features:signin"))
    implementation(project(":features:signup"))

    implementation(project(":features:upload"))

    implementation(project(":features:profile"))

    implementation(libs.lifecycle.viewmodel)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.blurry)

    implementation(libs.dagger)
    implementation(libs.activity)
    ksp(libs.dagger.compiler)

    implementation(libs.media3.exoplayer.session)

    implementation(libs.retrofit)
    implementation(libs.kotlin.serialization)
    implementation(libs.retrofit.kotlin.serialization.converter)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.contraintlayout)
    testImplementation(libs.juint)
    androidTestImplementation(libs.android.test.junit)
    androidTestImplementation(libs.android.test.espresso)
}