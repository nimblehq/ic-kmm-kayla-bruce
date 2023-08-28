package co.nimblehq.kaylabruce.kmmic.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            listOf(
                localModule,
                remoteModule,
                repositoryModule,
                useCaseModule,
                platformModule
            )
        )
    }
}
