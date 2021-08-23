package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

import kotlin.math.roundToInt

data class MovieDetail(
    val id: Int?,
    val backdrop_path: String?,
    val vote_average: Float?,
    val title: String?,
    //@SerializedName("releaseDate")
    private val release_date: String?,
    //valPG
    private val runtime: Int?,
    val genres: List<Genre>?,
    val overview: String?,
    val credits: List<CreditList>?
//    val credits: List<Cast>?
    )
{
    val voteAverage = (vote_average?.times(10))?.let { it.roundToInt() }.toString() + "%"


//    var instant: Instant? = Instant.parse("2017-10-30T02:00:00.000Z")
//    var date = Date.from(instant)
//    val formatRelease = SimpleDateFormat("yyyy")
//    val releaseDate = "yyyy".format(date?.time)

    private val runtimeMinutes = runtime?.rem(60)
    private val runtimeHours = (runtimeMinutes?.let { runtime?.minus(it) })?.div(60)
    val runtimeFormatted = runtimeHours.toString()+ "h" + runtimeMinutes.toString() + "min"
    //val runtimeFormatted = getString(R.string.runtime, runtimeHours.toString(), runtimeMinutes.toString())


//    if (it.iso_3166_1.equals("BR")) {
//    //Log.d("BRASIL", it.iso_3166_1.toString())
//    if (it.certification?.isNotEmpty() == true) {
//        binding.tvAge.text = it.certification.toString()
//    }
}

