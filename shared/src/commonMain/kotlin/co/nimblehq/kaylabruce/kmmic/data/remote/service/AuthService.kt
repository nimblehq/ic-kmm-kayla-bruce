package co.nimblehq.kaylabruce.kmmic.data.remote.service

import co.nimblehq.kaylabruce.kmmic.data.remote.model.request.RefreshTokenRequest
import co.nimblehq.kaylabruce.kmmic.data.remote.model.response.TokenResponse

interface AuthService {
    suspend fun refreshToken(body: RefreshTokenRequest): TokenResponse
}

class AuthServiceImpl(private val apiClient: ApiClient) : AuthService {

    override suspend fun refreshToken(body: RefreshTokenRequest): TokenResponse {
        return apiClient.post(
            path = "/v1/oauth/token",
            requestBody = body
        )
    }
}
