object Dependency {

    object BuildKonfig {
        val BUILD_KONFIG by lazy { "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Version.BUILD_KONFIG}" }
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
        val MATERIAL by lazy {"androidx.compose.material:material:${Version.COMPOSE_MATERIAL}" }
        val NAVIGATION by lazy { "androidx.navigation:navigation-compose:${Version.COMPOSE_NAVIGATION}" }
        val COIL by lazy { "io.coil-kt:coil-compose:${Version.COMPOSE_COIL}" }
    }

    object Kover {
        val KOVER = "org.jetbrains.kotlinx:kover:${Version.KOVER}"
    }
}
