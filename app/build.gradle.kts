plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinx.serialization)
    id("kotlin-parcelize")
}

android {
    namespace = "com.paul9834.storelist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.paul9834.storelist"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Junit : allow to test code
    testImplementation (libs.junit)
    // Kotlinx : allow to test coroutines
    testImplementation (libs.kotlinx.coroutines.test)

    // Coil : allow load pics from servers

    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // android lifecycle : allow to use viewmodel

    implementation(libs.androidx.lifecycle.viewmodel.compose) // Use the latest version

    // android navigation : allow to navigate between screens

    implementation(libs.androidx.navigation.compose)

    // Kotlinx : allow to serialize data

    implementation(libs.kotlinx.serialization.json) // Use the latest version

    // Retrofit : allow to get data from server
    implementation(libs.retrofit)
    implementation(libs.converter.gson)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}