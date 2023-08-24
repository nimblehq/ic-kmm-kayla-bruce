plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.KOVER)
    id(Plugin.GOOGLE_SERVICES)
    kotlin(Plugin.ANDROID)
}

val keystoreProperties = rootDir.loadGradleProperties("signing.properties")

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
    signingConfigs {
        create(Configuration.BuildTypes.RELEASE) {
            storeFile = file("../config/release.keystore")
            storePassword = keystoreProperties.getProperty("KEYSTORE_PASSWORD")
            keyPassword = keystoreProperties.getProperty("KEY_PASSWORD")
            keyAlias = keystoreProperties.getProperty("KEY_ALIAS")
        }
    }
    buildTypes {
        getByName(Configuration.BuildTypes.RELEASE) {
            isMinifyEnabled = true
            isDebuggable = false
            isShrinkResources = true
            signingConfig = signingConfigs[Configuration.BuildTypes.RELEASE]
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }

        getByName(Configuration.BuildTypes.DEBUG) {
            // For quickly testing build with proguard, enable this
            isMinifyEnabled = false
            signingConfig = signingConfigs[Configuration.BuildTypes.DEBUG]
        }
    }
    flavorDimensions += Configuration.Flavor.DIMENSION_VERSION
    productFlavors {
        create(Configuration.Flavor.STAGING) {
            applicationIdSuffix = ".${Configuration.Flavor.STAGING}"
        }

        create(Configuration.Flavor.PRODUCTION) {}
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            // Robolectric resource processing/loading https://github.com/robolectric/robolectric/pull/4736
            isIncludeAndroidResources = true
        }
        unitTests.all {
            if (it.name != "testStagingDebugUnitTest") {
                it.extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
                    isDisabled.set(true)
                }
            }
        }
        animationsDisabled = true
        packagingOptions {
            jniLibs {
                useLegacyPackaging = true
            }
        }
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
    implementation(Dependency.Compose.COIL)
    implementation(Dependency.Firebase.FIREBASE)
    implementation(Dependency.Compose.FOUNDATION)
}
