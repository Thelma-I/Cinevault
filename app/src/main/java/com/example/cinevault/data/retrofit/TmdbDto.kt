package com.example.cinevault.data.retrofit

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class TmdbPopularResponse(
    val page: Int,
    val results: List<TmdbMovieDto>
)

@Serializable
data class TmdbMovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String?
)
@Serializable
data class TmdbCreditsResponse(
    val cast: List<TmdbCastDto>
)

@Serializable
data class TmdbCastDto(
    val name: String,
    val character: String,
    @SerialName("profile_path") val profilePath: String?
)