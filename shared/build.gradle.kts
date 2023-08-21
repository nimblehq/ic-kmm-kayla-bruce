import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType

plugins {
    kotlin(Plugin.MULTIPLATFORM)
    kotlin(Plugin.COCOAPODS)
    id(Plugin.ANDROID_LIBRARY)
    id(Plugin.BUILD_KONFIG)
    id(Plugin.KOVER)
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
            linkerOpts += "-ld64"
        }
        xcodeConfigurationToNativeBuildType["DebugStaging"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["DebugProduction"] = NativeBuildType.DEBUG
        xcodeConfigurationToNativeBuildType["ReleaseStaging"] = NativeBuildType.RELEASE
        xcodeConfigurationToNativeBuildType["ReleaseProduction"] = NativeBuildType.RELEASE
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
    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests.all {
            if (it.name != "testDebugUnitTest") {
                it.extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
                    isDisabled.set(true)
                }
            }
        }
    }
}

buildkonfig {
    packageName = "co.nimblehq.kaylabruce.kmmic"

    // Default for Flavor.STAGING
    defaultConfigs {
        buildConfigField(
            STRING,
            "CLIENT_ID",
            BuildKonfig.CLIENT_ID_STAGING
        )
        buildConfigField(
            STRING,
            "CLIENT_SECRET",
            BuildKonfig.CLIENT_SECRET_STAGING
        )
        buildConfigField(
            STRING,
            "BASE_URL",
            BuildKonfig.BASE_URL_STAGING
        )
    }

    defaultConfigs(Configuration.Flavor.PRODUCTION) {
        buildConfigField(
            STRING,
            "CLIENT_ID",
            BuildKonfig.CLIENT_ID_PRODUCTION
        )
        buildConfigField(
            STRING,
            "CLIENT_SECRET",
            BuildKonfig.CLIENT_SECRET_PRODUCTION
        )
        buildConfigField(
            STRING,
            "BASE_URL",
            BuildKonfig.BASE_URL_PRODUCTION
        )
    }

    defaultConfigs(Configuration.Flavor.STAGING) {
        buildConfigField(
            STRING,
            "CLIENT_ID",
            BuildKonfig.CLIENT_ID_STAGING
        )
        buildConfigField(
            STRING,
            "CLIENT_SECRET",
            BuildKonfig.CLIENT_SECRET_STAGING
        )
        buildConfigField(
            STRING,
            "BASE_URL",
            BuildKonfig.BASE_URL_STAGING
        )
    }
}
