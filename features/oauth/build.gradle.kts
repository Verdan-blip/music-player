plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
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

    val daggerVersion = "2.48"
    implementation("com.google.dagger:dagger:$daggerVersion")
    ksp("com.google.dagger:dagger-compiler:$daggerVersion")

    val viewModelLifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelLifecycleVersion")

    val browserVersion = "1.8.0"
    implementation("androidx.browser:browser:$browserVersion")

    val fragmentKtxVersion = "1.6.2"
    implementation("androidx.fragment:fragment-ktx:$fragmentKtxVersion")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}