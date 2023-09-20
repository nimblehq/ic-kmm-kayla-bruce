package co.nimblehq.kaylabruce.kmmic.domain.exeption

data class ApiException(
    val code: String?,
    override val message: String?,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)
