package co.nimblehq.kaylabruce.kmmic.di

import co.nimblehq.kaylabruce.kmmic.data.remote.service.*
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val UNAUTHORIZED_API_CLIENT = "unauthorized_api_client"

val remoteModule = module {
    singleOf(::ApiClient)
    single(named(UNAUTHORIZED_API_CLIENT)) { ApiClient(get()) }
    single<AuthService> { AuthServiceImpl(get(named(UNAUTHORIZED_API_CLIENT))) }
}
