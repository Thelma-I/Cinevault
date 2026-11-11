package com.example.cinevault.data.retrofit
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.JsonClassDiscriminator

@Serializable
data class TmdbMovieResponse(
    val page: Int,
    val results: List<TmdbMovieDto>
)

@Serializable
data class TmdbMovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("release_date") val releaseDate: String?,
  //  @SerialName("genre_ids") val genreId: List<Int>
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_country") val originalCountry: String?,
    val status: String?,
    val tagline: String?
)

@Serializable
data class TmdbTvResponse(
    val page: Int,
    val results: List<TmdbTvDto>
)

@Serializable
data class TmdbTvDto(
    val id: Int,
    val name: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("first_air_date") val firstAirDate: String?,
  //  @SerialName("genre_ids") val genreId: List<Int>
    @SerialName("number_of_episodes") val numberOfEpisodes : Int?,
    @SerialName("number_of_seasons") val numberOfSeasons : Int?,
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_country") val originalCountry: String?,
    val status: String?,
    val tagline: String?
)



@Serializable
data class TmdbSearchResponse(
    val page: Int,
    val results: List<TmdbSearchResultDto> = emptyList()
)

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("media_type")
sealed interface TmdbSearchResultDto

@Serializable
@SerialName("tv")
data class TmdbTvSearchDto(
    val id: Int,
    val name: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("media_type")val mediaType: String?
) : TmdbSearchResultDto

@Serializable
@SerialName("movie")
data class TmdbMovieSearchDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("media_type")val mediaType: String?
) : TmdbSearchResultDto


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