package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.base.BaseViewModel
import co.nimblehq.kaylabruce.kmmic.domain.usecase.GetSurveyListUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import timber.log.Timber

private const val START_INDEX = 1
private const val PAGE_SIZE = 10

class HomeViewModel(
    private val getSurveyListUseCase: GetSurveyListUseCase,
): BaseViewModel() {
    fun init() {
        getSurveyList()
    }

    private fun getSurveyList() {
        getSurveyListUseCase(
            pageNumber = START_INDEX,
            pageSize = PAGE_SIZE,
        )
            .onStart {
                showLoading()
            }
            .onCompletion {
                hideLoading()
            }
            .catch { error ->
                _error.emit(error)
            }
            .onEach { surveys ->
                // TODO: Emit surveys
                println(surveys)
            }
            .launchIn(viewModelScope)
    }
}
