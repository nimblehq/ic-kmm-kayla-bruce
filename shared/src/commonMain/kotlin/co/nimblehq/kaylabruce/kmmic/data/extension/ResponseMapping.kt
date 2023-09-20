package co.nimblehq.kaylabruce.kmmic.data.extension

import co.nimblehq.jsonapi.model.JsonApiException
import co.nimblehq.kaylabruce.kmmic.domain.exeption.ApiException
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlin.experimental.ExperimentalTypeInference

@OptIn(ExperimentalTypeInference::class)
fun <T> flowTransform(@BuilderInference block: suspend FlowCollector<T>.() -> T) = flow {
    runCatching { block() }
        .onSuccess { emit(it) }
        .onFailure { throw it.mapError() }
}

private fun Throwable.mapError(): Throwable =
    when (this) {
        is JsonApiException -> ApiException(
            code = errors.first().code,
            message = errors.first().detail,
            cause = this
        )

        else -> this
    }
