package org.ucb.andrade_examen.swapi.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ucb.andrade_examen.swapi.domain.usecase.GetSwapisUseCase
import org.ucb.andrade_examen.swapi.presentation.state.SwapiEffect
import org.ucb.andrade_examen.swapi.presentation.state.SwapiEvent
import org.ucb.andrade_examen.swapi.presentation.state.SwapiUiState

class SwapiViewModel(
    val usecase: GetSwapisUseCase
) : ViewModel() {

    private val _effect = MutableSharedFlow<SwapiEffect>()
    val effect = _effect.asSharedFlow()

    private val _state = MutableStateFlow(SwapiUiState())
    val state = _state.asStateFlow()

    init {
        load()
    }

    fun emitEvent(event: SwapiEvent) {
        when (event) {
            is SwapiEvent.OnShowDetail -> {
                emitEffect(SwapiEffect.NavigateToDetail)
            }
        }
    }

    private fun emitEffect(effect: SwapiEffect) {
        viewModelScope.launch {
            _effect.emit(effect)
        }
    }

    fun load() {
        _state.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val result = usecase.invoke()

            result.onSuccess { data ->
                _state.update {
                    it.copy(list = data, isLoading = false)
                }
            }.onFailure { error ->
                _state.update {
                    it.copy(isLoading = false, error = error.message)
                }
            }
        }
    }
}