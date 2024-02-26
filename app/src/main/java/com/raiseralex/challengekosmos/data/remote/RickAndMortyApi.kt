package com.raiseralex.challengekosmos.data.remote

import android.database.Observable
import com.raiseralex.challengekosmos.data.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RickAndMortyApi {

    // Este método es una función suspendida que se utiliza para realizar una
    // solicitud a la API de "Rick and Morty" para obtener una lista de personajes.
    @Headers("Content-type:application/json")
    @GET("character/?page=1")
    suspend fun getCharacters(): CharactersResponse

}