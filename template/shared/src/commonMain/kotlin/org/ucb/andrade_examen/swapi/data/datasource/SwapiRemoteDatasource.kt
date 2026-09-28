package org.ucb.andrade_examen.swapi.data.datasource

import org.ucb.andrade_examen.swapi.data.dto.SwapiDto

interface SwapiRemoteDatasource {
    suspend fun getList(): List<SwapiDto>
}