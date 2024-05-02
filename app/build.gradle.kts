plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
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
}

dependencies {

    implementation(project(":data:auth"))
    implementation(project(":data:music"))
    implementation(project(":core:common"))
    implementation(project(":features:oauth"))
    implementation(project(":features:player:api"))
    implementation(project(":features:player:impl"))
    implementation(project(":features:feed:api"))
    implementation(project(":features:feed:impl"))

    implementation(libs.lifecycle.viewmodel)

    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.dagger)
    implementation(libs.activity)
    ksp(libs.dagger.compiler)

    implementation(libs.media3.session)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    implementation(libs.contraintlayout)
    testImplementation(libs.juint)
    androidTestImplementation(libs.android.test.junit)
    androidTestImplementation(libs.android.test.espresso)
}