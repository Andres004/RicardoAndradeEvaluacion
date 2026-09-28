package org.ucb.andrade_examen.swapi.data.mapper

import org.ucb.andrade_examen.swapi.data.dto.SwapiDto
import org.ucb.andrade_examen.swapi.domain.model.SwapiModel

fun SwapiDto.toModel() = SwapiModel(
    name = name ?: "Desconocido",
    height = height ?: "-",
    mass = mass ?: "-",
    hairColor = hairColor ?: "-",
    skinColor = skinColor ?: "-",
    eyeColor = eyeColor ?: "-",
    gender = gender ?: "-"
)