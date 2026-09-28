package org.ucb.andrade_examen.swapi.presentation.state

sealed interface SwapiEffect {
    data class ShowToast(val message: String) : SwapiEffect
    object NavigateToDetail : SwapiEffect
}