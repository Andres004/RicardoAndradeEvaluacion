package org.ucb.andrade_examen.swapi.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.ucb.andrade_examen.swapi.data.datasource.SwapiRemoteDatasource
import org.ucb.andrade_examen.swapi.data.dto.SwapiDto
import org.ucb.andrade_examen.swapi.data.dto.SwapiResponseDto

class SwapiService : SwapiRemoteDatasource {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    override suspend fun getList(): List<SwapiDto> {
        val response = client.get("https://swapi.dev/api/people/")
        try {
            val body = response.body<SwapiResponseDto>()
            return body.results
        } catch (e: Exception) {
            throw e
        }
    }
}