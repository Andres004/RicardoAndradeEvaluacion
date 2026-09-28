package org.ucb.andrade_examen.swapi.domain.repository

import org.ucb.andrade_examen.swapi.domain.model.SwapiModel

interface SwapiRepository {
    suspend fun getSwapis(): Result<List<SwapiModel>>
}