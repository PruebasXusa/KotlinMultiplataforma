package com.pmdm.ejemplokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform