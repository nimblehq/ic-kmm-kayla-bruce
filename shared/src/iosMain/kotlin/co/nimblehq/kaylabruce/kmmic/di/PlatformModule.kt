package co.nimblehq.kaylabruce.kmmic.di

import com.russhwolf.settings.*
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSBundle

@OptIn(ExperimentalSettingsImplementation::class)
actual val platformModule: Module
    get() = module {
        single { Darwin.create() }
        single<Settings> { KeychainSettings(NSBundle.mainBundle().bundleIdentifier.orEmpty()) }
    }
