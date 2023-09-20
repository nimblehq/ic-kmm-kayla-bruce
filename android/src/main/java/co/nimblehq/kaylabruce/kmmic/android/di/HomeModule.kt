package co.nimblehq.kaylabruce.kmmic.android.di

import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    viewModelOf(::HomeViewModel)
}
