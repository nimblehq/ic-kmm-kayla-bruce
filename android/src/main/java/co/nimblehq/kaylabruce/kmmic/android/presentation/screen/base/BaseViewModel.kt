package co.nimblehq.kaylabruce.kmmic.android.presentation.screen.base

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.nimblehq.kaylabruce.kmmic.android.presentation.navigation.SurveyDestination
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private var loadingCount: Int = 0
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    protected val _error = MutableStateFlow<Throwable?>(null)
    val error: StateFlow<Throwable?> = _error

    private val _navigator = MutableSharedFlow<SurveyDestination>()
    val navigator: SharedFlow<SurveyDestination> = _navigator

    protected fun showLoading() {
        if (loadingCount == 0) {
            _isLoading.value = true
        }
        loadingCount++
    }

    protected fun hideLoading() {
        loadingCount--
        if (loadingCount == 0) {
            _isLoading.value = false
        }
    }

    protected fun <T> Flow<T>.injectLoading(): Flow<T> = this
        .onStart { showLoading() }
        .onCompletion { hideLoading() }

    fun clearError() {
        viewModelScope.launch { _error.emit(null) }
    }
}
