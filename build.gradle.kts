buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependency.Kotlin.GRADLE)
        classpath(Dependency.Kotlin.KOTLIN_GRADLE_PLUGIN)
        classpath(Dependency.Kotlin.KOTLIN_SERIALIZATION)
        classpath(Dependency.BuildKonfig.BUILD_KONFIG)
        classpath(Dependency.Google.GOOGLE_SERVICES)
        classpath(Dependency.Kover.KOVER)
    }
}

plugins {
    id(Plugin.DETEKT).version(Version.DETEKT)
    id(Plugin.KOVER_PACKAGE).version(Version.KOVER)
}

allprojects {
    apply {
    }
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven {
            name = "Github Packages"
            url = uri("https://maven.pkg.github.com/nimblehq/jsonapi-kotlin")
            credentials {
                username = BuildKonfig.GITHUB_USER
                password = BuildKonfig.GITHUB_TOKEN
            }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

detekt {
    toolVersion = Version.DETEKT

    source = files(
        "android/src",
        "shared/src"
    )

    parallel = false
    config = files("$projectDir/detekt.yml")
    buildUponDefaultConfig = false
    allRules = false
    disableDefaultRuleSets = false
    debug = false

    ignoreFailures = false
    ignoredBuildTypes = listOf("release")
    ignoredFlavors = listOf("production")
    ignoredVariants = listOf("productionRelease")

    basePath = "$projectDir"
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
    }
}

koverMerged {
    enable()

    val excludedFiles = listOf(
        "com.russhwolf.settings.*",
        "io.mockative.*",
        "*.BuildConfig",
        "*.BuildKonfig",                        // BuildKonfig generated
        "*.ComposableSingletons*",              // Jetpack Compose generated
        "*.*\$*Preview\$*",                     // Jetpack Compose Preview functions
        "*.di.*",                               // Koin
        "*.ui.preview.*",                       // Jetpack Compose Preview providers
        "*.*Test",                              // Test files
        "*.*Test*",                             // Test cases
        "*.*Mock",                              // mockative @Mock generated
        "*.test.*",                             // Test util package
        "*.*\$\$serializer",                    // Kotlinx serializer
    )
    filters {
        classes {
            excludes += excludedFiles
        }
    }
}
