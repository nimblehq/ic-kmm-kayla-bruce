package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.home

import androidx.lifecycle.viewModelScope
import co.nimblehq.kaylabruce.kmmic.android.presentation.screen.base.BaseViewModel
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.SurveyUiModel
import co.nimblehq.kaylabruce.kmmic.android.presentation.uimodel.toUiModel
import co.nimblehq.kaylabruce.kmmic.domain.usecase.GetSurveyListUseCase
import kotlinx.coroutines.flow.*

private const val START_INDEX = 1
private const val PAGE_SIZE = 10

class HomeViewModel(
    private val getSurveyListUseCase: GetSurveyListUseCase,
) : BaseViewModel() {
    private val _surveyList = MutableStateFlow(emptyList<SurveyUiModel>())
    val surveyList: StateFlow<List<SurveyUiModel>> = _surveyList

    fun init() {
        getSurveyList()
    }

    private fun getSurveyList() {
        getSurveyListUseCase(
            pageNumber = START_INDEX,
            pageSize = PAGE_SIZE,
        )
            .injectLoading()
            .catch { _error.emit(it) }
            .onEach { surveys ->
                _surveyList.emit(surveys.map { it.toUiModel() })
            }
            .launchIn(viewModelScope)
    }
}
