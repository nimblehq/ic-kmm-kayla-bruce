package co.nimblehq.kaylabruce.kmmic.domain.repository

import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun refreshToken(refreshToken: String): Flow<Token>

    fun saveToken(token: Token)
}
