package co.nimblehq.kaylabruce.kmmic.data.local

import co.nimblehq.kaylabruce.kmmic.domain.model.Token
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

const val TOKEN_TYPE = "token_type"
const val ACCESS_TOKEN = "access_token"
const val REFRESH_TOKEN = "refresh_token"
const val EXPIRES_IN = "expires_in"

interface LocalService {

    val tokenType: String?

    val accessToken: String?

    val refreshToken: String?

    val expiresIn: Int?
    fun saveToken(token: Token)
    fun clear()
}

class LocalServiceImpl(private val settings: Settings) : LocalService {

    override val tokenType: String?
        get() = settings.getStringOrNull(TOKEN_TYPE)

    override val accessToken: String?
        get() = settings.getStringOrNull(ACCESS_TOKEN)

    override val refreshToken: String?
        get() = settings.getStringOrNull(REFRESH_TOKEN)

    override val expiresIn: Int?
        get() = settings.getIntOrNull(EXPIRES_IN)

    override fun saveToken(token: Token) = with(token) {
        settings[TOKEN_TYPE] = tokenType
        settings[ACCESS_TOKEN] = accessToken
        settings[REFRESH_TOKEN] = refreshToken
        settings[EXPIRES_IN] = expiresIn
    }

    override fun clear() = settings.clear()
}
