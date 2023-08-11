package co.nimblehq.kaylabruce.kmmic

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
