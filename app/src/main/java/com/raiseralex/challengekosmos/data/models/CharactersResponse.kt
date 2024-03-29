package com.raiseralex.challengekosmos.data.models

import com.google.gson.annotations.SerializedName

// En este caso solo agregare el Json de Character que se encuentra en el List results..
data class CharactersResponse(
    @SerializedName("results") val results: List<Character> = emptyList()
)
data class Character(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin")val origin: Origin,
    @SerializedName("location")val location: Location,
    @SerializedName("image")val image: String,
    @SerializedName("episode")val episode: List<String>,
    @SerializedName("url")val url: String,
    @SerializedName("created")val created: String
)

data class Origin(
    val name: String,
    val url: String?
)

data class Location(
    val name: String,
    val url: String?
)