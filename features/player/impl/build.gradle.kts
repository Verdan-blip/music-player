plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "ru.kpfu.itis.bagaviev.feature.player.impl"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    implementation(project(":player:api"))

    implementation(project(":core:common"))
    implementation(project(":core:theme"))

    implementation(libs.coil)

    implementation(libs.fragment.ktx)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.guava)

    implementation(libs.media3.exoplayer)
    implementation(libs.media3.exoplayer.ui)
    implementation(libs.media3.exoplayer.dash)

    implementation(libs.blurry)

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    testImplementation(libs.juint)
    androidTestImplementation(libs.android.test.junit)
    androidTestImplementation(libs.android.test.espresso)
}