package com.schratzenstaller.wilcilene.mynewmovieinfo.api.model

data class MovieDetailApiResult(
    val id: Int?,
    val backdrop_path: String?,
    val vote_average: Float?,
    val title: String?,
    val release_date: String?,
    val runtime: Int?,
    val genres: List<GenreApiResult>?,
    val overview: String?,
    val credits: CreditListApiResult?
)