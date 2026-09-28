package org.ucb.andrade_examen.swapi.domain.usecase

import org.ucb.andrade_examen.swapi.domain.model.SwapiModel
import org.ucb.andrade_examen.swapi.domain.repository.SwapiRepository

class GetSwapisUseCase(
    private val repository: SwapiRepository
) {
    suspend operator fun invoke(): Result<List<SwapiModel>> {
        return repository.getSwapis()
    }
}