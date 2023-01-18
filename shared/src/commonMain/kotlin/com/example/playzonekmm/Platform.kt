package com.example.playzonekmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform