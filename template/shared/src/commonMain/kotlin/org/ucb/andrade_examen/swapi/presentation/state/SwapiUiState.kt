package org.ucb.andrade_examen.swapi.presentation.state

import org.ucb.andrade_examen.swapi.domain.model.SwapiModel

data class SwapiUiState(
    val isLoading: Boolean = false,
    val list: List<SwapiModel> = emptyList(),
    val error: String? = null
)