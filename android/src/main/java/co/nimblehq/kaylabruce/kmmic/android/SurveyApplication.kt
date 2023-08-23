package co.nimblehq.kaylabruce.kmmic.android

import android.app.Application
import co.nimblehq.kaylabruce.kmmic.di.initKoin
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import timber.log.Timber

class SurveyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initKoin {
            androidContext(applicationContext)
        }
    }
}
