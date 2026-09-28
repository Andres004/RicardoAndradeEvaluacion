package org.ucb.andrade_examen

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration
import org.ucb.andrade_examen.di.appModule
import org.ucb.andrade_examen.swapi.presentation.screen.SwapiScreen

@Composable
@Preview
fun App() {
    KoinApplication(
        configuration = koinConfiguration {
            modules(appModule)
        }
    ) {
        MaterialTheme {
            SwapiScreen()
        }
    }
}
