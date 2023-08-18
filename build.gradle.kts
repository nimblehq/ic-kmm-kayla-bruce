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
    }
}

plugins {
    id(Plugin.DETEKT).version(Version.DETEKT)
}

allprojects {
    apply {
    }
    repositories {
        google()
        mavenCentral()
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
