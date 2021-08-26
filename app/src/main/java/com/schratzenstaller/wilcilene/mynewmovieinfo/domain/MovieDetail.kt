package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

import kotlin.math.roundToInt

data class MovieDetail(
    val id: Int?,
    val backdrop_path: String?,
    private val vote_average: Float?,
    val title: String?,
    val release_date: String?,
    private val runtime: Int?,
    val genres: List<Genre>?,
    val overview: String?,
    val credits: List<Cast>?,
) {

    val voteAverage = (vote_average?.times(10))?.roundToInt().toString() + "%"

    val releaseDate = release_date?.substring(0, 4)

    private val runtimeMinutes = runtime?.rem(60)
    private val runtimeHours = (runtimeMinutes?.let { runtime?.minus(it) })?.div(60)
    val runtimeFormatted = runtimeHours.toString() + "h" + runtimeMinutes.toString() + "min"

}
