package org.ucb.andrade_examen.swapi.presentation.state

sealed interface SwapiEvent {
    data class OnShowDetail(val id: String) : SwapiEvent
}