plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.kpfu.itis.oauth"
    compileSdk = 34

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String", "JAMENDO_API_AUTH_URL",
            "\"https://api.jamendo.com/v3.0/oauth/authorize\""
        )
        buildConfigField(
            "String", "JAMENDO_API_CLIENT_ID",
            "\"2210a65fb17ba702705814843f859983\""
        )
        buildConfigField(
            "String", "JAMENDO_API_CLIENT_SECRET",
            "\"460a7a7a\""
        )
        buildConfigField("String", "JAMENDO_API_REDIRECT_URL",
            "\"ru.kpfu.itis.bagaviev://jamendo.com/callback\""
        )
        buildConfigField("String", "JAMENDO_API_LOGOUT_URL",
            "\"ru.kpfu.itis.bagaviev://jamendo.com/logout_callback\""
        )
        buildConfigField("String", "JAMENDO_API_SCOPE",
            "\"music\""
        )
        buildConfigField("String", "JAMENDO_API_RESPONSE_TYPE",
            "\"code\""
        )
        buildConfigField("String", "JAMENDO_API_BASE_URL",
            "\"https://api.jamendo.com\""
        )
        buildConfigField("String", "JAMENDO_API_GRAND_TYPE",
            "\"authorization_code\""
        )

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
        buildConfig = true
        viewBinding = true
    }
}

dependencies {
    
    implementation(project(":core:common"))

    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    implementation(libs.viewmodel)

    implementation(libs.browser)

    implementation(libs.fragment.ktx)

    implementation(libs.android.core)
    implementation(libs.android.appcompat)
    implementation(libs.android.material)
    testImplementation(libs.juint)
    androidTestImplementation(libs.android.test.junit)
    androidTestImplementation(libs.android.test.espresso)
}