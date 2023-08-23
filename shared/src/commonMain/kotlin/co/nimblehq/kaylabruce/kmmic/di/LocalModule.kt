package co.nimblehq.kaylabruce.kmmic.di

import co.nimblehq.kaylabruce.kmmic.data.local.LocalService
import co.nimblehq.kaylabruce.kmmic.data.local.LocalServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val localModule = module {
    singleOf(::LocalServiceImpl) bind LocalService::class
}
