package org.ucb.andrade_examen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform