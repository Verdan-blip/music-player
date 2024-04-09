plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.kpfu.itis.bagaviev.player"
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

    implementation(project(":core:theme"))
    implementation(project(":core:common"))

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    implementation(libs.media3.exoplayer)
    implementation(libs.media3.dash)
    implementation(libs.media3.session)
    implementation(libs.media3.ui)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.legacy.support.v4)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.viewmodel)
    implementation(libs.fragment.ktx)
    testImplementation(libs.juint)
    androidTestImplementation(libs.android.test.junit)
    androidTestImplementation(libs.android.test.espresso)
}