package org.example.redraw

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform