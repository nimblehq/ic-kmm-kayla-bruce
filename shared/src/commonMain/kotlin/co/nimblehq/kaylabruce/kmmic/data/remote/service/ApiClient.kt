package co.nimblehq.kaylabruce.kmmic.data.remote.service

import co.nimblehq.jsonapi.json.JsonApi
import co.nimblehq.kaylabruce.kmmic.BuildKonfig
import co.nimblehq.kaylabruce.kmmic.data.local.LocalService
import co.nimblehq.kaylabruce.kmmic.domain.usecase.RefreshTokenUseCase
import io.github.aakira.napier.*
import io.github.aakira.napier.LogLevel
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.last
import kotlinx.serialization.json.Json

class ApiClient(
    engine: HttpClientEngine,
    localDataSource: LocalService? = null,
    refreshTokenUseCase: RefreshTokenUseCase? = null
) {

    val httpClient: HttpClient
    val json = Json {
        prettyPrint = true
        isLenient = true
        encodeDefaults = true
        ignoreUnknownKeys = true
    }

    init {
        Napier.takeLogarithm()
        Napier.base(DebugAntilog())

        httpClient = HttpClient(engine) {
            install(Logging) {
                level = io.ktor.client.plugins.logging.LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.log(LogLevel.DEBUG, message = message)
                    }
                }
            }

            install(ContentNegotiation) {
                json(json)
            }

            if (localDataSource != null && refreshTokenUseCase != null) {
                install(Auth) {
                    bearer {
                        loadTokens {
                            val accessToken = localDataSource.accessToken
                            val refreshToken = localDataSource.refreshToken
                            return@loadTokens if (accessToken != null && refreshToken != null) {
                                BearerTokens(accessToken, refreshToken)
                            } else null
                        }

                        refreshTokens {
                            val token = refreshTokenUseCase.execute(refreshToken = oldTokens?.refreshToken.orEmpty())
                                .last()
                            BearerTokens(token.accessToken, token.refreshToken)
                        }

                        sendWithoutRequest { request ->
                            request.url.host == Url(BuildKonfig.BASE_URL).host
                        }
                    }
                }
            }
        }
    }

    suspend inline fun <reified T> get(path: String): T =
        request(path, HttpMethod.Get)

    suspend inline fun <reified T> post(path: String, requestBody: Any): T =
        request(path, HttpMethod.Post, requestBody)

    suspend inline fun <reified T> request(path: String, method: HttpMethod, requestBody: Any? = null): T {
        val body = httpClient.request(
            HttpRequestBuilder().apply {
                this.method = method
                path(path)
                requestBody?.let { setBody(requestBody) }
                contentType(ContentType.Application.Json)
            }
        ).bodyAsText()

        if (Unit is T) {
            return Unit
        }
        return JsonApi(json).decodeFromJsonApiString(body)
    }
}

fun HttpRequestBuilder.path(path: String) {
    url(BuildKonfig.BASE_URL.plus(path))
}
