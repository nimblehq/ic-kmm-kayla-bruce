package co.nimblehq.kaylabruce.kmmic.data.repository

import co.nimblehq.kaylabruce.kmmic.data.local.LocalStorageService
import co.nimblehq.kaylabruce.kmmic.data.remote.model.request.RefreshTokenRequest
import co.nimblehq.kaylabruce.kmmic.data.remote.model.response.toToken
import co.nimblehq.kaylabruce.kmmic.data.remote.service.AuthService
import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import co.nimblehq.kaylabruce.kmmic.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthService,
    private val localStorageService: LocalStorageService
) : AuthRepository {

    override fun saveToken(token: Token) {
        localStorageService.saveToken(token)
    }

    override fun refreshToken(refreshToken: String): Flow<Token> = flow {
        authRemoteDataSource
            .refreshToken(RefreshTokenRequest(refreshToken = refreshToken))
            .toToken()
    }
}
