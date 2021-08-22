package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.math.roundToInt

data class MovieDetail(
    val id: Int?,
    @SerializedName("backdropPath")
    val backdrop_path: String?,
    //@SerializedName("voteAverage")
    val vote_average: Float?,
    val title: String?,
    //@SerializedName("releaseDate")
    private val release_date: Date?,
    //valPG
    private val runtime: Int?,
    val genres: List<Genre>?,
    val overview: String?,
    //val credits: List<CreditList>?
    val credits: List<Cast>?
    )
{
    val voteAverage = (vote_average?.times(10))?.let { it.roundToInt() }.toString() + "%"

    //val formatRelease = SimpleDateFormat("yyyy")
    val releaseDate = "yyyy".format(release_date?.time)

    private val runtimeMinutes = runtime?.rem(60)
    private val runtimeHours = (runtimeMinutes?.let { runtime?.minus(it) })?.div(60)
    val runtimeFormatted = runtimeHours.toString()+ "h" + runtimeMinutes.toString() + "min"
    //val runtimeFormatted = getString(R.string.runtime, runtimeHours.toString(), runtimeMinutes.toString())
}

