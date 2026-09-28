package org.ucb.andrade_examen.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.ucb.andrade_examen.swapi.data.datasource.SwapiRemoteDatasource
import org.ucb.andrade_examen.swapi.data.repository.SwapiRepositoryImpl
import org.ucb.andrade_examen.swapi.data.service.SwapiService
import org.ucb.andrade_examen.swapi.domain.repository.SwapiRepository
import org.ucb.andrade_examen.swapi.domain.usecase.GetSwapisUseCase
import org.ucb.andrade_examen.swapi.presentation.viewmodel.SwapiViewModel

val appModule = module {
    single<SwapiRemoteDatasource> { SwapiService() }
    single<SwapiRepository> { SwapiRepositoryImpl(get()) }
    factory { GetSwapisUseCase(get()) }
    viewModelOf(::SwapiViewModel)
}
