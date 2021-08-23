package com.schratzenstaller.wilcilene.mynewmovieinfo.domain

import com.google.gson.annotations.SerializedName

data class CreditList(
    //val crew: List<Crew>?,
    val cast: List<Cast>?
)
data class Crew(
//    @SerializedName("profilePath")
    val profile_path: String?,
    val name: String?,
    val job: String?
)

class Cast(
//    @SerializedName("profilePath")
    val profile_path: String?,
    val name: String?,
    val character: String?
)