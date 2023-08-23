package co.nimblehq.kaylabruce.kmmic.data.remote.model.response

import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(
    @SerialName("id")
    val id: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("token_type")
    val tokenType: String? = null,
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("expires_in")
    val expiresIn: Int? = null,
    @SerialName("created_at")
    val createdAt: Int? = null
)

fun TokenResponse.toToken() = Token(
    accessToken = accessToken.orEmpty(),
    refreshToken = refreshToken.orEmpty(),
    tokenType = tokenType.orEmpty(),
    expiresIn = expiresIn ?: 0,
    createdAt = createdAt ?: 0
)
