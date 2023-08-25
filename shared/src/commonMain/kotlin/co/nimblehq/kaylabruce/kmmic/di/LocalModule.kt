package co.nimblehq.kaylabruce.kmmic.di

import co.nimblehq.kaylabruce.kmmic.data.local.LocalStorageService
import co.nimblehq.kaylabruce.kmmic.data.local.LocalStorageServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localModule = module {
    singleOf(::LocalStorageServiceImpl) bind LocalStorageService::class
}
