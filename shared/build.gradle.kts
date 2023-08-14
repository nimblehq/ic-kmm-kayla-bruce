import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING

plugins {
    kotlin(Plugin.MULTIPLATFORM)
    kotlin(Plugin.COCOAPODS)
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.BUILD_KONFIG)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        name = "shared"
        summary = "Shared Cocoa Pods"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../ios/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "co.nimblehq.kaylabruce.kmmic"
    compileSdk = Version.ANDROID_COMPILE_SDK
    defaultConfig {
        minSdk = Version.ANDROID_DEFAULT_MIN_SDK
    }
}

buildkonfig {
    packageName = "co.nimblehq.kaylabruce.kmmic"

    // Default for Flavors.STAGING
    defaultConfigs {

    }
}
