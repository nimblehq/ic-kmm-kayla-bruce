object Dependency {

    object BuildKonfig {
        val BUILD_KONFIG by lazy { "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Version.BUILD_KONFIG}" }
    }

    object Coroutines {
        val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.COROUTINES}"
        val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.COROUTINES}"
    }

    object Kotlin {
        val GRADLE by lazy { "com.android.tools.build:gradle:${Version.GRADLE}" }
        val KOTLIN_GRADLE_PLUGIN by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN}" }
        val KOTLIN_SERIALIZATION by lazy { "org.jetbrains.kotlin:kotlin-serialization:${Version.KOTLIN}" }
        val KOTLIN_TEST by lazy { "org.jetbrains.kotlin:kotlin-test:${Version.KOTLIN}" }
    }

    object Compose {
        val UI by lazy { "androidx.compose.ui:ui:${Version.COMPOSE_UI}" }
        val UI_GRAPHICS by lazy { "androidx.compose.ui:ui-graphics:${Version.COMPOSE_UI}" }
        val UI_TOOLING by lazy { "androidx.compose.ui:ui-tooling:${Version.COMPOSE_UI}" }
        val UI_TOOLING_PREVIEW by lazy { "androidx.compose.ui:ui-tooling-preview:${Version.COMPOSE_UI}" }
        val MATERIAL by lazy { "androidx.compose.material:material:${Version.COMPOSE_MATERIAL}" }
        val NAVIGATION by lazy { "androidx.navigation:navigation-compose:${Version.COMPOSE_NAVIGATION}" }
        val COIL by lazy { "io.coil-kt:coil-compose:${Version.COMPOSE_COIL}" }
        val FOUNDATION by lazy { "androidx.compose.foundation:foundation:${Version.COMPOSE_FOUNDATION}" }
    }

    object Koin {
        val CORE = "io.insert-koin:koin-core:${Version.KOIN}"
        val ANDROID = "io.insert-koin:koin-android:${Version.KOIN_ANDROID}"
        val COMPOSE = "io.insert-koin:koin-androidx-compose:${Version.KOIN_ANDROID}"
        val TEST = "io.insert-koin:koin-test:${Version.KOIN}"
    }

    object Kover {
        val KOVER = "org.jetbrains.kotlinx:kover:${Version.KOVER}"
    }

    object Google {
        const val GOOGLE_SERVICES = "com.google.gms:google-services:${Version.GOOGLE_SERVICES}"
        const val ACCOMPANIST = "com.google.accompanist:accompanist-placeholder:${Version.GOOGLE_ACCOMPANIST}"
    }

    object Firebase {
        const val FIREBASE = "com.google.firebase:firebase-bom:${Version.FIREBASE}"
    }

    object Ktor {
        val CORE = "io.ktor:ktor-client-core:${Version.KTOR}"
        val SERIALIZATION = "io.ktor:ktor-client-serialization:${Version.KTOR}"
        val LOGGING = "io.ktor:ktor-client-logging:${Version.KTOR}"
        val CIO = "io.ktor:ktor-client-cio:${Version.KTOR}"
        val CONTENT_NEGOTIATION = "io.ktor:ktor-client-content-negotiation:${Version.KTOR}"
        val JSON = "io.ktor:ktor-serialization-kotlinx-json:${Version.KTOR}"
        val AUTH = "io.ktor:ktor-client-auth:${Version.KTOR}"
        val ANDROID = "io.ktor:ktor-client-android:${Version.KTOR}"
        val IOS = "io.ktor:ktor-client-ios:${Version.KTOR}"
    }

    object Napier {
        val NAPIER = "io.github.aakira:napier:${Version.NAPIER}"
    }

    object JsonApi {
        val JSON_API = "co.nimblehq.jsonapi:core:${Version.JSON_API}"
    }

    object Settings {
        val SETTINGS = "com.russhwolf:multiplatform-settings:${Version.SETTINGS}"
        val SERIALIZATION =
            "com.russhwolf:multiplatform-settings-serialization:${Version.SETTINGS}"
    }

    object Timber {
        val TIMBER = "com.jakewharton.timber:timber:${Version.TIMBER}"
    }

    object Preference {
        val PREFERENCE = "androidx.preference:preference-ktx:${Version.PREFERENCE}"
    }
}
