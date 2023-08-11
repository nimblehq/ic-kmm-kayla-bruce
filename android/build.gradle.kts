plugins {
    id(Plugin.ANDROID_APPLICATION)
    kotlin(Plugin.ANDROID)
}

android {
    namespace = "co.nimblehq.kaylabruce.kmmic.android"
    compileSdk = Version.ANDROID_COMPILE_SDK
    defaultConfig {
        applicationId = "co.nimblehq.kaylabruce.kmmic.android"
        minSdk = Version.ANDROID_MIN_SDK
        targetSdk = Version.ANDROID_TARGET_SDK
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
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
    implementation(project(Configuration.Module.SHARED))
    implementation(Dependency.Compose.UI)
    implementation(Dependency.Compose.UI_GRAPHICS)
    implementation(Dependency.Compose.UI_TOOLING)
    implementation(Dependency.Compose.UI_TOOLING_PREVIEW)
    implementation(Dependency.Compose.MATERIAL)
    implementation(Dependency.Compose.NAVIGATION)
}
