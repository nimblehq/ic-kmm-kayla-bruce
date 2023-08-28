package co.nimblehq.kaylabruce.kmmic.domain.model

data class Token(
    val accessToken: String,
    val tokenType: String,
    val refreshToken: String,
    val expiresIn: Int,
    val createdAt: Int
)
