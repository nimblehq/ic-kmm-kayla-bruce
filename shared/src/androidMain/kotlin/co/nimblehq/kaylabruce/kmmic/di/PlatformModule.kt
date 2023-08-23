package co.nimblehq.kaylabruce.kmmic.di

import androidx.preference.PreferenceManager
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import io.ktor.client.engine.android.Android
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { Android.create() }
        single<Settings> { SharedPreferencesSettings(PreferenceManager.getDefaultSharedPreferences(get())) }
    }
