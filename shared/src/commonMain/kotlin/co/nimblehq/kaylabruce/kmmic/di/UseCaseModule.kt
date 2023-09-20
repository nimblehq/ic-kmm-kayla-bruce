package co.nimblehq.kaylabruce.kmmic.di

import co.nimblehq.kaylabruce.kmmic.domain.usecase.*
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::RefreshTokenUseCase)
    singleOf(::GetSurveyListUseCaseImpl) bind GetSurveyListUseCase::class
}
