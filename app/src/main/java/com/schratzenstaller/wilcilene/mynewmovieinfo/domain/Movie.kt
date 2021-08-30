package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

import kotlin.math.roundToInt

data class Movie(
    val id: Int?,
    val posterPath: String?,
    val title: String?,
    private val vote_average: Double?
)
{
    val voteAverage = (vote_average?.times(10))?.roundToInt().toString() + "%"
}