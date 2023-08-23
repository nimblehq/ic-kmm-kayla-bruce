package co.nimblehq.kaylabruce.kmmic.data.remote.model.request

import co.nimblehq.kaylabruce.kmmic.data.local.REFRESH_TOKEN
import co.nimblehq.kaylabruce.kmmic.BuildKonfig
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequest(
    @SerialName("grant_type")
    val grantType: String = REFRESH_TOKEN,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("client_id")
    val clientId: String = BuildKonfig.CLIENT_ID,
    @SerialName("client_secret")
    val clientSecret: String = BuildKonfig.CLIENT_SECRET,
)
