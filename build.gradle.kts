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
