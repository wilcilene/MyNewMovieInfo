package com.schratzenstaller.wilcilene.mynewmovieinfo.api.model

data class MovieListApiResult(
    val page: Int?,
    val results: List<MovieApiResult>?
)