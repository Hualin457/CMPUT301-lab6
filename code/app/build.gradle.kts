plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.lab6_listycity"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.lab6_listycity"
        minSdk = 24
        targetSdk = 36
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
    tasks.withType<Test> {
        useJUnitPlatform()
    }
    tasks.withType<Javadoc>().configureEach {
        options {
            locale = "en_US"
            encoding = "UTF-8"
            charset("UTF-8")
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(files("C:/Users/Defic/AppData/Local/Android/Sdk/platforms/android-36/android.jar"))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}