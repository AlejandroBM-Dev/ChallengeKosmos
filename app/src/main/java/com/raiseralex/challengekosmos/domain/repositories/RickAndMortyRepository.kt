package com.raiseralex.challengekosmos.domain.repositories

import com.raiseralex.challengekosmos.data.models.CharactersResponse
import com.raiseralex.challengekosmos.data.remote.RickAndMortyApi
import javax.inject.Inject
import javax.inject.Singleton

// Esta clase será responsable de interactuar con la API para obtener datos de personajes.
@Singleton
class RickAndMortyRepository@Inject constructor(
    private val api: RickAndMortyApi
) {
    suspend fun getCharacters(): CharactersResponse {
        val response = api.getCharacters()
        return response
    }
}