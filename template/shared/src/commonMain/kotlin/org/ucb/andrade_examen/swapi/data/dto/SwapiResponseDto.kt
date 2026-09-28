package org.ucb.andrade_examen.swapi.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class SwapiResponseDto(
    val results: List<SwapiDto>
)
