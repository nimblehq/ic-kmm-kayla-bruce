package co.nimblehq.kaylabruce.kmmic.domain.usecase

import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import co.nimblehq.kaylabruce.kmmic.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class RefreshTokenUseCase(private val repository: AuthRepository) {

    fun execute(refreshToken: String): Flow<Token> {
        return repository.refreshToken(refreshToken)
            .onEach { token -> repository.saveToken(token) }
    }
}

