package com.schratzenstaller.wilcilene.mynewmovieinfo.api.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.math.roundToInt

data class MovieListApiResult(
    val page: Int?,
    //val total_pages: Int,
    //val total_results: Int?,
    val results: List<MovieApiResult>?
)

data class MovieApiResult(
    val id: Int?,
    val poster_path: String?,
    val title: String?,
    val vote_average: Double?
)

data class MovieDetailApiResult(
    val id: Int?,
    val backdrop_path: String?,
    val vote_average: Float?,
    val title: String?,
    val release_date: String?,
    //valPG
    val runtime: Int?,
    val genres: List<GenreApiResult>?,
    val overview: String?,
//    val credits: CastApiResult?
    val credits: CreditListApiResult?
)
data class GenreListApiResult(
    val genres: List<GenreApiResult>?
)

data class GenreApiResult(
    val id: String?,
    val name: String?
)
data class CreditListApiResult(
    val crew: List<CrewApiResult>?,
    val cast: List<CastApiResult>?
)

data class CrewApiResult(
    val profile_path: String?,
    val name: String?,
    val job: String?
)

class CastApiResult(
    val profile_path: String?,
    val name: String?,
    val character: String?
)

/*release_date
data class MovieCertification(
    val id: String?,
    val results: List<ReleaseDates>?
)

data class ReleaseDates(
    val certification: String?,
    val release_date: Date?,
    val iso_3166_1: String?
)
//cast
//if function = Acting then character OU
//if character is not null then character else if job is not null then job else department

 */