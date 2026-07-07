package io.github.semenciuccosmin.lexiscore

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform