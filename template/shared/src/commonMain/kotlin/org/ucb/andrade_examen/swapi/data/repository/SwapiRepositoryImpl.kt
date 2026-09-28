package org.ucb.andrade_examen.swapi.data.repository

import org.ucb.andrade_examen.swapi.data.datasource.SwapiRemoteDatasource
import org.ucb.andrade_examen.swapi.domain.model.SwapiModel
import org.ucb.andrade_examen.swapi.domain.repository.SwapiRepository
import org.ucb.andrade_examen.swapi.data.mapper.toModel

class SwapiRepositoryImpl(
    val remote: SwapiRemoteDatasource
): SwapiRepository {
    override suspend fun getSwapis(): Result<List<SwapiModel>> {
        return try {
            val list = remote.getList()
            Result.success(list.map { it.toModel() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}